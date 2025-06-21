#!/bin/bash

QUEUE_NAME="idempotency-teste"
REGION="sa-east-1"
ENDPOINT_URL="http://localhost:4566"

MESSAGE_BODY='{"id": "TR#123", "status": "AUTORIZADO", "valor": "2.01"}'

# Envio da mensagem
aws sqs send-message \
    --queue-url "${ENDPOINT_URL}/000000000000/${QUEUE_NAME}" \
    --message-body "${MESSAGE_BODY}" \
    --region ${REGION} \
    --endpoint-url ${ENDPOINT_URL}

echo "Mensagem enviada com sucesso para a fila ${QUEUE_NAME}."
