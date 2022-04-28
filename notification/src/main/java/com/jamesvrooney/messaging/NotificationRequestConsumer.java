package com.jamesvrooney.messaging;

import com.jamesvrooney.clients.notification.model.NotificationRequest;
import com.jamesvrooney.service.NoticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationRequestConsumer {

    private final NoticationService noticationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consume(NotificationRequest notificationRequest) {

        log.info("Consuming NotificationRequest: {} from queue", notificationRequest);

        noticationService.saveNotification(notificationRequest);
    }
}
