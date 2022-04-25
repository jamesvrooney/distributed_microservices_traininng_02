package com.jamesvrooney.service;

import com.jamesvrooney.model.FraudCheckHistory;
import com.jamesvrooney.model.FraudCheckResponse;
import com.jamesvrooney.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public FraudCheckResponse isFraudulentCustomer(UUID customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return FraudCheckResponse.builder().isFraudster(false).build();
    }
}
