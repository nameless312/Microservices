package org.nameless.infra;

import org.nameless.core.customer.CustomerService;
import org.nameless.core.customer.CustomerServiceImpl;
import org.nameless.infra.customer.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
}
