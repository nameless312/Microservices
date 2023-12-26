package org.nameless.customer.infra;

import org.nameless.customer.core.Customer;

public interface CustomerRepository {
    void saveCustomer(Customer customer);
    Customer findByCustomerId(Integer customerId);
}
