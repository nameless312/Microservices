package com.nameless.infra;

import org.nameless.customer.core.CustomerService;
import org.nameless.customer.core.CustomerServiceImpl;
import org.nameless.customer.infra.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerJPARepository();
    }
    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
}
