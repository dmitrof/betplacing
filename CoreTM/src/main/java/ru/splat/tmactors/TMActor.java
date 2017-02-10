package ru.splat.tmactors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import com.google.protobuf.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import ru.splat.kafka.serializer.ProtoBufMessageSerializer;
import ru.splat.messages.conventions.ServicesEnum;
import ru.splat.messages.conventions.TaskTypesEnum;
import ru.splat.messages.uptm.TMResponse;
import ru.splat.messages.uptm.trmetadata.LocalTask;
import ru.splat.messages.uptm.trmetadata.TransactionMetadata;
import ru.splat.messages.uptm.trstate.ServiceResponse;
import ru.splat.messages.uptm.trstate.TransactionState;
import ru.splat.tmmessages.RetrySendMsg;
import ru.splat.tmmessages.ServiceResponseMsg;
import ru.splat.tmmessages.TaskSentMsg;
import ru.splat.tmprotobuf.ProtobufFactory;

import java.util.*;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


/**
 * Created by Дмитрий on 05.01.2017.
 */
public  class TMActor extends AbstractActor {
    private KafkaProducer<Long, Message> producer;
    private Map<Long, TransactionState> states = new HashMap<>();
    private final ActorRef registry;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(TransactionMetadata.class, m -> {
                    createTransactionState(m);
                    processTransaction(m);
                })
                .match(TaskSentMsg.class, this::setIsSent)
                .match(RetrySendMsg.class, m -> send(m.getTopic(), m.getTransactionId(), m.getMessage()))
                .match(ServiceResponseMsg.class, this::processResponse)
                .build();
    }

    //создание стейта транзакции при получении ответа от сервисов (заглушка для сложной процедуры коммита кафки)
    public void createTransactionState(Long transactionId, Map<TaskTypesEnum, ServiceResponse> localStates) {

    }
    //создание стейта транзакции из метадаты
    public void createTransactionState(TransactionMetadata transactionMetadata) {
        Long trId = transactionMetadata.getTransactionId();
        Map<ServicesEnum, ServiceResponse> responseMap = new HashMap<>();
        transactionMetadata.getLocalTasks().forEach(localTask -> {
            responseMap.put(localTask.getService(), new ServiceResponse());    //создание "пустых ответов от сервисов"
        });
        /*Map<TaskTypesEnum, ServiceResponse> responseMap = transactionMetadata.getLocalTasks().stream().map(localTask -> localTask)
                .collect(Collectors.toMap(LocalTask::getType, new ServiceResponse()));*/   ///выяснить почему не работает
        TransactionState transactionState = new TransactionState(transactionMetadata.getTransactionId(),responseMap);
        states.put(trId, transactionState);
    }

    public void processTransaction(TransactionMetadata trMetadata) {
        List<LocalTask> taskList = trMetadata.getLocalTasks();
        Long transactionId = trMetadata.getTransactionId();
        System.out.println("TMActor: transactionId " + transactionId);
        Set<ServicesEnum> services = taskList.stream().map(task -> task.getService())
                .collect(Collectors.toSet());
        taskList.forEach(task->{
            Message message = ProtobufFactory.buildProtobuf(task, services);
            send(SERVICE_TO_TOPIC_MAP.get(task.getService()), transactionId, message);
        });
    }


    private void send(String topic, Long transactionId, Message message) {
        System.out.println("TMActor: sending " + transactionId + " to " + topic);
        Future isSend = producer.send(new ProducerRecord<Long, Message>(topic, transactionId, message),
                (metadata, e) -> {
                    if (e != null) getSelf().tell(new RetrySendMsg(topic, transactionId, message), getSelf());
                    else getSelf().tell(new TaskSentMsg(transactionId, TOPIC_TO_SERVICE_MAP.get(topic)), getSelf());
                });
    }

    private void processResponse(ServiceResponseMsg serviceResponseMsg) {
        Long trId = serviceResponseMsg.getTransactionId();
        if (!states.containsKey(trId)) {
            return;
        }
        ServiceResponse response = serviceResponseMsg.getMessage();
        System.out.println("TMActor: response for " + trId + " :" + response.getResult());
        states.get(trId).getLocalStates()   //may there be null pointer?
                .put(serviceResponseMsg.getService(), response);
        TransactionState transactionState = states.get(trId);
        Boolean allReceived = transactionState.getLocalStates()
                .entrySet().stream().map(state -> state.getValue().isResponseReceived())
                .allMatch(e -> e);
        if (allReceived) {
            registry.tell(transactionState, getSelf());
            states.remove(trId);
        }

    }

    public void setIsSent(TaskSentMsg m) {
        System.out.println("task " + m.getService().toString() + " of " + m.getTransactionId() + " is sent");
        Long trId = m.getTransactionId();
        states.get(trId).getLocalStates()   //may there be null pointer?
                .get(m.getService()).setRequestSent(true);
        Boolean allSent = states.get(trId).getLocalStates()
                .entrySet().stream().map(state -> state.getValue().isRequestSent())
                .allMatch(e -> e);
        if (allSent) {
            registry.tell(new TMResponse(trId), getSelf());
        }
        //for testing
        /*ServiceResponse rs = states.get(m.getTransactionId()).getLocalStates()
                .get(m.getService());
        System.out.println("sent: " + rs.isRequestSent() + "received: " + rs.isResponseReceived() + "positive " + rs.isPositive());*/
    }

    public TMActor(ActorRef registry) {
        Properties propsProducer = new Properties();
        propsProducer.put("bootstrap.servers", "localhost:9092");
        propsProducer.put("acks", "all");
        propsProducer.put("retries", 0);
        propsProducer.put("batch.size", 16384);
        propsProducer.put("linger.ms", 1);
        propsProducer.put("buffer.memory", 33554432);
        producer = new KafkaProducer(propsProducer, new LongSerializer(), new ProtoBufMessageSerializer());
        this.registry = registry;
    }
    private static Map<ServicesEnum, String> SERVICE_TO_TOPIC_MAP;
    private static Map<String, ServicesEnum> TOPIC_TO_SERVICE_MAP;

    static {
        SERVICE_TO_TOPIC_MAP = new HashMap<>();
        SERVICE_TO_TOPIC_MAP.put(ServicesEnum.BetService, "BetReq");
        SERVICE_TO_TOPIC_MAP.put(ServicesEnum.EventService, "EventReq");
        SERVICE_TO_TOPIC_MAP.put(ServicesEnum.BillingService, "BillingReq");
        SERVICE_TO_TOPIC_MAP.put(ServicesEnum.PunterService, "PunterReq");
        TOPIC_TO_SERVICE_MAP = new HashMap<>();
        TOPIC_TO_SERVICE_MAP.put("BetReq", ServicesEnum.BetService);
        TOPIC_TO_SERVICE_MAP.put("EventReq", ServicesEnum.EventService);
        TOPIC_TO_SERVICE_MAP.put("BillingReq", ServicesEnum.BillingService);
        TOPIC_TO_SERVICE_MAP.put("PunterReq", ServicesEnum.PunterService);

    }



}

