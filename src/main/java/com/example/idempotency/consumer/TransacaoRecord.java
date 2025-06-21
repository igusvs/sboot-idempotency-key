package com.example.idempotency.consumer;

public record TransacaoRecord (String id, String status, String valor){
}
