package com.jamesvrooney.clients.fraud;

import com.jamesvrooney.clients.fraud.model.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping("api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable UUID customerId);
}
