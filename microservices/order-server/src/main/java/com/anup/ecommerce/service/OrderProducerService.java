package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.OrderConfirmationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducerService {

    private final KafkaTemplate<String, OrderConfirmationRequest> kafkaTemplate;

    public void sendOrderConfirmation(OrderConfirmationRequest orderConfirmationRequest) {
        log.info("Sending order confirmation: {}", orderConfirmationRequest);

        Message<OrderConfirmationRequest> message = MessageBuilder
                .withPayload(orderConfirmationRequest)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();

        kafkaTemplate.send(message);
    }
}
