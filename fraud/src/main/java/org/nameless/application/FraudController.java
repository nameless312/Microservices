package org.nameless.application;

import lombok.extern.slf4j.Slf4j;
import org.nameless.core.fraud.FraudService;
import org.nameless.fraud.FraudCheckResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/fraud-check")
public class FraudController {
    private final FraudService fraudService;

    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerID) {
        boolean isFraudulentCustomer = fraudService.
                isFraudster(customerID);
        log.info("fraud check request for customer {}", customerID);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
