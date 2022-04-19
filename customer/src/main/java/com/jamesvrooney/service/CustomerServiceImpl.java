package com.jamesvrooney.service;

import com.jamesvrooney.model.CreateCustomerCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CreateCustomerCommand createCustomer(CreateCustomerCommand customer) {
        log.info("Create new customer");

        return null;
    }
}
