package com.br.meupedido.meupedido.web.messagering.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${meuPedido.queueName}")
    private String queueName;
    @Bean
    public Queue queue () {
        return new Queue(queueName);
    }

    @Bean
    public RabbitAdmin rabbitAdmin (ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener
            (RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }
}
