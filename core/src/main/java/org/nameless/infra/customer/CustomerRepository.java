package org.nameless.infra.customer;

import org.nameless.core.customer.Customer;

public interface CustomerRepository {
    void saveCustomer(Customer customer);
    Customer findByCustomerId(Integer customerId);
}
