package com.jamesvrooney.service;

import com.jamesvrooney.model.CreateCustomerCommand;
import com.jamesvrooney.model.Customer;
import com.jamesvrooney.model.FraudCheckResponse;
import com.jamesvrooney.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Override
    public Customer getCustomer(UUID customerId) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("Customer with this id does NOT exist");
                });

        return customer;
    }

    @Override
    public Customer createCustomer(CreateCustomerCommand customerCommand) {
        log.info("Create new customer");

        var customer = Customer.builder()
                .firstName(customerCommand.getFirstName())
                .lastName(customerCommand.getLastName())
                .email(customerCommand.getEmail())
                .build();

        var savedCustomer = customerRepository.save(customer);

        restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                savedCustomer.getId());

        return savedCustomer;
    }
}
