package org.nameless.infra.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.nameless.core.notification.Notification;
import org.nameless.core.notification.NotificationService;
import org.nameless.notification.NotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {
    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerName())
                .message(notificationRequest.message())
                .build();
        notificationService.send(notification);
    }
}
