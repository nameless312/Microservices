package org.nameless.application;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.nameless.core.notification.Notification;
import org.nameless.core.notification.NotificationService;
import org.nameless.notification.NotificationRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public void sendNotification(@Valid @RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerName())
                .message(notificationRequest.message())
                .build();
        notificationService.send(notification);
    }
}
