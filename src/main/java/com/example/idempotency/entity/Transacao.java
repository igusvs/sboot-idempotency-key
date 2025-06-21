package com.example.idempotency.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@DynamoDbBean
public class Transacao {

    private String id;
    private String status;
    private String valor;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

}
