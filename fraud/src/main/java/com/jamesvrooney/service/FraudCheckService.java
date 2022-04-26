package com.jamesvrooney.service;

import com.jamesvrooney.clients.fraud.model.FraudCheckResponse;

import java.util.UUID;

public interface FraudCheckService {
    FraudCheckResponse isFraudulentCustomer(UUID customerId);
}
