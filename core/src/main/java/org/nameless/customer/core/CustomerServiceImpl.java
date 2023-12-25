package org.nameless.customer.core;
import org.nameless.customer.infra.CustomerRepository;

public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {
    public void registerCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
