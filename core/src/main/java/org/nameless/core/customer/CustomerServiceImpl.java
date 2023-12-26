package org.nameless.core.customer;
import org.nameless.infra.customer.CustomerRepository;

public record CustomerServiceImpl(CustomerRepository customerRepository) implements CustomerService {
    public void registerCustomer(Customer customer) {
        customer = customerRepository.saveCustomer(customer);
        // check email

        // check if fraudster

    }
}
