package com.jamesvrooney.config;

import com.jamesvrooney.messaging.RabbitMQMessageProducer;
import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class QueueConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        TopicExchange topicExchange = new TopicExchange(internalExchange);

        return topicExchange;
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder.bind(notificationQueue())
                .to(internalTopicExchange())
                .with(internalNotificationRoutingKey);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer) {
//        var payload = new Person("James", 47);
//
//        return args -> {
//            producer.publish(payload,
//                    internalExchange,
//                    internalNotificationRoutingKey);
//        };
//    }
//
//    record Person(
//            String name,
//            int age
//    ){}
}
