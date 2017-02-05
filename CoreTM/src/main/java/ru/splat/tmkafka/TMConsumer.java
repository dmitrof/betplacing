package ru.splat.tmkafka;

import com.google.protobuf.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import ru.splat.messages.Response;

/**
 * Created by Дмитрий on 06.01.2017.
 */
public interface TMConsumer {
    public ConsumerRecords<Long, Response.ServiceResponse> pollRecords();
}
