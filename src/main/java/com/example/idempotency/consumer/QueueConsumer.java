package com.example.idempotency.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

public class QueueConsumer {

    @SqsListener(queueNames = "idempotency-teste")
    public void consumer(@Payload String payload, @Header Map<String, String> headers){
        final var payload2 = payload;
        final var payload3 = headers;

    }
}
