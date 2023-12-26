package org.nameless.infra;

import org.nameless.core.fraud.FraudService;
import org.nameless.core.fraud.FraudServiceImpl;
import org.nameless.infra.fraud.FraudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FraudService fraudService(FraudRepository fraudRepository) {
        return new FraudServiceImpl(fraudRepository);
    }
}
