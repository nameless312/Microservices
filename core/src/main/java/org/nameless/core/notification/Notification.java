package org.nameless.core.notification;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
public record Notification(
        Integer notificationId,
        Integer toCustomerId,
        String toCustomerEmail,
        String sender,
        String message,
        LocalDateTime sentAt
) {
}