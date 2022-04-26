package com.jamesvrooney.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudCheckHistory {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;
}
