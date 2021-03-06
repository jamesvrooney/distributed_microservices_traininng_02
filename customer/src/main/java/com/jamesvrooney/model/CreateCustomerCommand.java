package com.jamesvrooney.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerCommand {
    private String firstName;
    private String lastName;
    private String email;
}
