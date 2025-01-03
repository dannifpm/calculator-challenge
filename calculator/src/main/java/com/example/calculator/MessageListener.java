package com.example.calculator;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "calculatorQueue")
    public void processMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
