package com.jamesvrooney.service;

import com.jamesvrooney.model.CreateCustomerCommand;
import com.jamesvrooney.model.Customer;

public interface CustomerService {
    CreateCustomerCommand createCustomer(CreateCustomerCommand customer);
}
