package com.jamesvrooney.service;

import com.jamesvrooney.model.CreateCustomerCommand;
import com.jamesvrooney.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer createCustomer(CreateCustomerCommand customer);

    Customer getCustomer(UUID customerId);
}
