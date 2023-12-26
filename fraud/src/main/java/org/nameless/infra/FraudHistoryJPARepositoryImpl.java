package org.nameless.infra;

import org.nameless.core.fraud.FraudHistory;
import org.nameless.infra.fraud.FraudRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class FraudHistoryJPARepositoryImpl implements FraudRepository {
    private final FraudHistoryJPARepository fraudHistoryJPARepository;

    public FraudHistoryJPARepositoryImpl(@Lazy FraudHistoryJPARepository fraudHistoryJPARepository) {
        this.fraudHistoryJPARepository = fraudHistoryJPARepository;
    }

    @Override
    public void saveFraudHistory(FraudHistory fraudHistory) {
        fraudHistoryJPARepository.save(mapToEntity(fraudHistory));
    }

    @Override
    public FraudHistory findByCustomerId(Integer customerId) {
        return null;
    }


    private FraudHistoryEntity mapToEntity(FraudHistory fraudHistory) {
        return FraudHistoryEntity.builder()
                .customerId(fraudHistory.getCustomerId())
                .isFraudster(fraudHistory.getIsFraudster())
                .createdAt(fraudHistory.getCreatedAt())
                .build();
    }

    private FraudHistory mapToDomainModel(FraudHistoryEntity fraudHistoryEntity) {
        return FraudHistory.builder()
                .id(fraudHistoryEntity.getId())
                .customerId(fraudHistoryEntity.getCustomerId())
                .isFraudster(fraudHistoryEntity.getIsFraudster())
                .createdAt(fraudHistoryEntity.getCreatedAt())
                .build();
    }
}
