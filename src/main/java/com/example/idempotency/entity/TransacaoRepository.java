package com.example.idempotency.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TransacaoRepository {


    @Autowired
    DynamoDbClient dynamoDbClient;

    public void save(TransacaoDomain transacaoDomain) {

        Map<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("id", AttributeValue.builder().s(transacaoDomain.getId()).build());
        itemValues.put("status", AttributeValue.builder().s(transacaoDomain.getStatus()).build());
        itemValues.put("valor", AttributeValue.builder().n(transacaoDomain.getValor()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName("transacao")
                .item(itemValues)
                .build();


        dynamoDbClient.putItem(request);
    }
    public void update(TransacaoDomain transacaoDomain) {

        Map<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("id", AttributeValue.builder().s(transacaoDomain.getId()).build());
        itemValues.put("status", AttributeValue.builder().s(transacaoDomain.getStatus()).build());
        itemValues.put("valor", AttributeValue.builder().n(transacaoDomain.getValor()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName("transacao")
                .item(itemValues)
                .build();


        dynamoDbClient.updateItem()
    }
}
