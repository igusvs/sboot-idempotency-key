package com.example.idempotency.consumer;

import com.example.idempotency.entity.TransacaoDomain;
import com.example.idempotency.entity.TransacaoRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class QueueConsumer {

    @Autowired
    TransacaoRepository repository;

    @SqsListener("idempotency-teste")
    public void consumer(@Payload TransacaoRecord payload){

        final var transacao = new TransacaoDomain();
        transacao.setId(payload.id());
        transacao.setStatus(payload.status());
        transacao.setValor(payload.valor());

        repository.save(transacao);

    }
}
