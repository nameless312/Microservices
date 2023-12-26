package org.nameless.application;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.nameless.core.customer.Customer;
import org.nameless.core.customer.CustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void registerCustomer(@Valid @RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerService.registerCustomer(customer);
    }
}
