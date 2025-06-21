package com.example.idempotency.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QueueConsumer {

    @SqsListener("idempotency-teste")
    public void consumer(@Payload String payload){
        final var payload2 = payload;

    }
}
