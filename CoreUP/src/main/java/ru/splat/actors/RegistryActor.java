package ru.splat.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import ru.splat.LoggerGlobal;
import ru.splat.message.RegisterRequest;
import ru.splat.message.RegisterResponse;
import ru.splat.messages.uptm.trstate.TransactionState;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Иван on 21.12.2016.
 */
public class RegistryActor extends AbstractActor {
    private final Map<Long, ActorRef> actors;


    @Override
    public Receive createReceive() {
        return receiveBuilder().match(RegisterRequest.class, this::processRegisterRequest)
                .match(TransactionState.class, this::processTransactionState)
                .matchAny(this::unhandled).build();

    }

    public RegistryActor(Integer size) {
        actors = new HashMap<>(size);
    }

    private void processTransactionState(TransactionState o) {
        LoggerGlobal.log("Processing TransactionState: " + o.toString());

        actors.get(o.getTransactionId())
                .tell(o, self());
    }

    private void processRegisterRequest(RegisterRequest request) {
        LoggerGlobal.log("Processing RegisterRequest: " + request.toString());

        actors.put(request.getTransactionId(), request.getActor());
        sender().tell(new RegisterResponse(), self());
    }


}
