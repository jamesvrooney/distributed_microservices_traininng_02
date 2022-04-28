package com.jamesvrooney.config;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate amqpTemplate = new RabbitTemplate(connectionFactory);

        amqpTemplate.setMessageConverter(jacksonMessageConverter());

        return  amqpTemplate;
    }

    @Bean
    public MessageConverter jacksonMessageConverter() {
        MessageConverter messageConverter = new Jackson2JsonMessageConverter();

        return messageConverter;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jacksonMessageConverter());

        return factory;
    }
}
