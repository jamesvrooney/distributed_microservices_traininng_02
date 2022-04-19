package com.jamesvrooney.controller;

import com.jamesvrooney.model.CreateCustomerCommand;
import com.jamesvrooney.model.Customer;
import com.jamesvrooney.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        var customer = Customer.builder()
                .id(Integer.getInteger(customerId))
                .firstName("James")
                .lastName("Rooney")
                .email("jamesvrooney@hotmail.com")
                .build();

        return customer;
    }

    @PostMapping("register")
    public CreateCustomerCommand registerCustomer(@RequestBody CreateCustomerCommand customer) {
        CreateCustomerCommand createdCustomer = customerService.createCustomer(customer);

        return createdCustomer;
    }
}
