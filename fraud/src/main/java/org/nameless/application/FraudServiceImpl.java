package org.nameless.application;

import lombok.extern.slf4j.Slf4j;
import org.nameless.core.fraud.FraudHistory;
import org.nameless.core.fraud.FraudService;
import org.nameless.infra.fraud.FraudRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record FraudServiceImpl(FraudRepository fraudRepository) implements FraudService {
    @Override
    public Boolean isFraudster(Integer customerId) {
        log.info("Requested fraud check for customer with id {}", customerId);
        FraudHistory fraudHistory = fraudRepository().findByCustomerId(customerId);
        return fraudHistory != null && fraudHistory.getIsFraudster();
    }
}
