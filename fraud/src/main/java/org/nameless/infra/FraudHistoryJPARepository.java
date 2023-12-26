package org.nameless.infra;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FraudHistoryJPARepository extends JpaRepository<FraudHistoryEntity, Integer> {
}
