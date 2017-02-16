package ru.splat.tm.messages;

import akka.actor.AbstractActor;
//import org.slf4j.Logger;
import ru.splat.messages.uptm.TMResponse;
import ru.splat.messages.uptm.trstate.TransactionState;

import ru.splat.tm.LoggerGlobal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import akka.event.Logging;
import akka.event.LoggingAdapter;




/**
 * Created by Дмитрий on 18.01.2017.
 */
public class MockRegistry extends AbstractActor {
    private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public MockRegistry() {
        log.info("Registry ready");
    }

    private void processState(TransactionState m) {
        log.info("Registry: state received" + m.getTransactionId() +
                " with " + m.getLocalStates().size());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TMResponse.class, m -> log.info("Registry: all requests for " + m.getTransactionId()+ " are sent"))
                .match(TransactionState.class, this::processState)
                .build();
    }
}
