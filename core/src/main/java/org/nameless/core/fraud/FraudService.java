package org.nameless.core.fraud;

import org.nameless.core.customer.Customer;

public interface FraudService {
    Boolean isFraudster(Integer customerId);
}
