package com.jamesvrooney.controller;

import com.jamesvrooney.clients.notification.model.NotificationRequest;
import com.jamesvrooney.service.NoticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NoticationService noticationService;

    @PostMapping
    void saveNotification(@RequestBody NotificationRequest notificationRequest) {

        noticationService.saveNotification(notificationRequest);

        log.info("Saving notification");
    }
}
