package org.nameless.core.customer;
import org.nameless.infra.customer.CustomerRepository;

public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {
    public void registerCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }
}
