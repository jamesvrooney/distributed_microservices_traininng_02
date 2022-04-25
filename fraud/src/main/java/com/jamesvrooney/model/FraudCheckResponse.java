package com.jamesvrooney.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FraudCheckResponse {
    private boolean isFraudster;
}
