package org.nameless.application;

import lombok.Builder;
import lombok.Data;

@Builder
public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}