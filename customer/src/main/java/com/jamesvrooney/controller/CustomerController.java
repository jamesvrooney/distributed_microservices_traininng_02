package com.jamesvrooney.controller;

import com.jamesvrooney.model.CreateCustomerCommand;
import com.jamesvrooney.model.Customer;
import com.jamesvrooney.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable UUID customerId) {

        var customer = customerService.getCustomer(customerId);

        return customer;
    }

    @PostMapping("register")
    public Customer registerCustomer(@RequestBody CreateCustomerCommand customer) {
        Customer createdCustomer = customerService.createCustomer(customer);

        return createdCustomer;
    }
}
