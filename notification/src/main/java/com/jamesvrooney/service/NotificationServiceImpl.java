package com.jamesvrooney.service;

import com.jamesvrooney.clients.notification.model.NotificationRequest;
import com.jamesvrooney.model.Notification;
import com.jamesvrooney.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NoticationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void saveNotification(NotificationRequest notificationRequest) {
        log.info("Saving notification request");

        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerEmail())
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .sender("jamesvrooney")
                        .build()
        );
    }
}
