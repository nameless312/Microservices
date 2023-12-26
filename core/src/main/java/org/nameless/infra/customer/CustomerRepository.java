package org.nameless.infra.customer;

import org.nameless.core.customer.Customer;

public interface CustomerRepository {
    Customer saveCustomer(Customer customer);
    Customer findByCustomerId(Integer customerId);
}
