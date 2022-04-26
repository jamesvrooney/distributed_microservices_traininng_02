package com.jamesvrooney.repository;

import com.jamesvrooney.clients.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, UUID> {
}
