package com.jamesvrooney.service;

import com.jamesvrooney.clients.fraud.FraudClient;
import com.jamesvrooney.clients.fraud.model.FraudCheckResponse;
import com.jamesvrooney.model.CreateCustomerCommand;
import com.jamesvrooney.model.Customer;
import com.jamesvrooney.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

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

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(savedCustomer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("This customer is a fraudster");
        }

        return savedCustomer;
    }
}
