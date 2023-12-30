package org.nameless.notification;

import lombok.Builder;
import lombok.Data;

@Builder
public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String subject,
        String message
) {
}