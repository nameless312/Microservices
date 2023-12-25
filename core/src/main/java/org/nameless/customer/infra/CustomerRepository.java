package org.nameless.customer.infra;

import org.nameless.customer.core.Customer;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(String customerId);
}
