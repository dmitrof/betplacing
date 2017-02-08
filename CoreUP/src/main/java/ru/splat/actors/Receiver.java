package ru.splat.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import ru.splat.LoggerGlobal;
import ru.splat.messages.Transaction;
import ru.splat.messages.proxyup.ProxyUPMessage;
import ru.splat.messages.proxyup.bet.BetInfo;
import ru.splat.messages.proxyup.bet.NewRequest;
import ru.splat.messages.proxyup.check.CheckRequest;
import ru.splat.message.*;
import scala.concurrent.Future;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ru.splat.messages.Transaction.State;

/**
 * Actor which receives messages from users and from id_generator.
 */
public class Receiver extends UntypedActor {
    public static final String NOT_ACTIVE_TR = "TRANSACTION IS NOT IN PROCESS";

    private final ActorRef registry;
    private final ActorRef idGenerator;
    private final ActorRef tmActor;

    private final Set<Integer> userIds;
    private final Map<Long, Transaction.State> results;
    private final Map<Integer, ActorRef> current;

    public Receiver(ActorRef registry, ActorRef idGenerator, ActorRef tmActor) {
        this.registry = registry;
        this.idGenerator = idGenerator;
        this.tmActor = tmActor;

        userIds = new HashSet<>();
        results = new HashMap<>();
        current = new HashMap<>();
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof InnerMessage) {
            processInnerMessage((InnerMessage) message);
        } else if(message instanceof ProxyUPMessage) {
            processProxyMessage((ProxyUPMessage) message);
        }
    }

    //new request from proxy
    private void processProxyMessage(ProxyUPMessage message) {
        if(message instanceof NewRequest) {
            processNewRequest((NewRequest) message);
        } else {
            processCheckRequest((CheckRequest) message);
        }
    }

    private void processCheckRequest(CheckRequest message) {
        LoggerGlobal.log("Processing CheckRequest: " + message.toString());

        State state = results.get(message.getTransactionId());
        if(state == null) {
            answer(NOT_ACTIVE_TR);
        } else {
            answer(state);
        }
    }

    private void processNewRequest(NewRequest message) {
        LoggerGlobal.log("Processing NewRequest: " + message.toString());

        BetInfo betInfo = message.getBetInfo();
        Integer userId = betInfo.getUserId();
        boolean alreadyActive = userIds.contains(userId);

        if(alreadyActive) {
            LoggerGlobal.log("Already active: " + userId);

            answer("ALREADY ACTIVE");
        } else {
            LoggerGlobal.log("User now active: " + userId);

            userIds.add(userId);
            current.put(userId, getSender());
            idGenerator.tell(new CreateIdRequest(betInfo), getSelf());
        }
    }

    //message from one of actors
    private void processInnerMessage(InnerMessage message) {
        if(message instanceof CreateIdResponse) {
            processTransactionReady(((CreateIdResponse)message).getTransaction());
        } else if(message instanceof RecoverRequest) {
            processDoRecover(((RecoverRequest)message).getTransaction());
        } else if(message instanceof PhaserResponse) {
            processRequestResult(((PhaserResponse) message).getTransaction());
        }
    }

    private void processDoRecover(Transaction transaction) {
        LoggerGlobal.log("Process DoRecover: " + transaction.toString());

        startTransaction(transaction);
    }

    private void processTransactionReady(Transaction transaction) {
        LoggerGlobal.log("Process TransactionReady: " + transaction.toString());

        startTransaction(transaction);
        current.get(transaction.getBetInfo()
                .getUserId()).tell(transaction, getSelf());
    }

    private void startTransaction(Transaction transaction) {
        saveState(transaction);
        createPhaser(transaction);
    }

    private void createPhaser(Transaction transaction) {
        LoggerGlobal.log("Creating phaser for transaction: " + transaction.toString());

        ActorRef phaser = newActor(PhaserActor.class, "phaser" + transaction.getLowerBound(), tmActor, getSelf());
        ActorRef receiver = getSelf();

        Future<Object> future = Patterns.ask(registry,
                new RegisterRequest(transaction.getLowerBound(), phaser),
                Timeout.apply(10L, TimeUnit.MINUTES));

        future.onSuccess(new OnSuccess<Object>() {
            @Override
            public void onSuccess(Object o) throws Throwable {
                phaser.tell(new PhaserRequest(transaction), receiver);
            }
        }, getContext().dispatcher());
    }

    private void processRequestResult(Transaction transaction) {
        LoggerGlobal.log("Process RequestResult: " + transaction.toString());

        saveState(transaction);
    }

    private void saveState(Transaction transaction) {
        results.put(transaction.getLowerBound(), transaction.getState());
    }

    private void answer(Object msg) {
        getSender().tell(msg, getSelf());
    }

    private ActorRef newActor(Class<?> clazz, String name, Object... args) {
        return getContext().actorOf(Props.create(clazz, args), name);
    }
}
