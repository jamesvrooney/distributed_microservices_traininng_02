package com.jamesvrooney.service;

import com.jamesvrooney.clients.notification.model.NotificationRequest;

public interface NoticationService {
    void saveNotification(NotificationRequest notificationRequest);
}
