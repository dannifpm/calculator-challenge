package com.example.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue-name:calculatorQueue}")
    private String queueName;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
