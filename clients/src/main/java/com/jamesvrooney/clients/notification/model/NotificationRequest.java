package com.jamesvrooney.clients.notification.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

//@Getter
//@Setter
@Data
@Builder
public class NotificationRequest {
    private UUID toCustomerId;
    private String toCustomerEmail;
    private String message;
}
