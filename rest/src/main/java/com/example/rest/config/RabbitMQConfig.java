package com.example.rest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue calculatorQueue() {
        return new Queue("calculatorQueue", true); 
    }
}