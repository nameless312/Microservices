package org.nameless.infra.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitNotificationConsumer {
//    private final NotificationService notificationService;
//    private final MailService mailService;
//
//    public NotificationConsumer(NotificationService notificationService, MailService mailService) {
//        this.notificationService = notificationService;
//        this.mailService = mailService;
//    }

//    @RabbitListener(queues = "${rabbitmq.queues.notification}")
//    public void consumer(NotificationRequest notificationRequest) {
//        log.info("Consumed {} from queue", notificationRequest);
//        Notification notification = Notification.builder()
//                .toCustomerId(notificationRequest.toCustomerId())
//                .toCustomerEmail(notificationRequest.toCustomerName())
//                .subject(notificationRequest.subject())
//                .message(notificationRequest.message())
//                .build();
//        notificationService.saveNotification(notification);
//        mailService.sendEmail(notification);
//    }
}
