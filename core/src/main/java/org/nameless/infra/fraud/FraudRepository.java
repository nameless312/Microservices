package org.nameless.infra.fraud;

import org.nameless.core.customer.Customer;
import org.nameless.core.fraud.FraudHistory;

public interface FraudRepository {
    void saveFraudHistory(FraudHistory fraudHistory);
    FraudHistory findByCustomerId(Integer customerId);
}
