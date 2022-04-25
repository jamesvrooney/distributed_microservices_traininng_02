package com.jamesvrooney.controller;

import com.jamesvrooney.model.FraudCheckResponse;
import com.jamesvrooney.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable UUID customerId) {
        FraudCheckResponse  fraudCheckResponse = fraudCheckService.isFraudulentCustomer(customerId);

        return fraudCheckResponse;
    }
}
