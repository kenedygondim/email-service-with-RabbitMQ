package com.project.email_microservice.infra.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    @Value("${broker.queue.email.name}")
    private String queue;
    @Bean
    public Queue queue() {
        return new Queue(this.queue, true); //durable: a fila vai ser persistida se o servidor cair?
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    } //Vai ser útil para realizar as conversões de JSON para Dto

}
