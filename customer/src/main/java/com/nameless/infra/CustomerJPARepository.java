package com.nameless.infra;

import org.nameless.customer.core.Customer;
import org.nameless.customer.infra.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerJPARepository implements CustomerRepository {
    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(String customerId) {
        return null;
    }
}
