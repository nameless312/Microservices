package org.nameless.core.fraud;

import org.nameless.infra.fraud.FraudRepository;

public record FraudServiceImpl(FraudRepository fraudRepository) implements FraudService {
    @Override
    public Boolean isFraudster(Integer customerId) {
        FraudHistory fraudHistory = fraudRepository().findByCustomerId(customerId);
        return fraudHistory != null && fraudHistory.getIsFraudster();
    }
}
