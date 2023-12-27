package org.nameless.application;

import lombok.extern.slf4j.Slf4j;
import org.nameless.core.notification.Notification;
import org.nameless.core.notification.NotificationService;
import org.nameless.infra.notification.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record NotificationServiceImpl(NotificationRepository notificationRepository) implements NotificationService {

    @Override
    public void send(Notification notification) {
        notificationRepository.saveNotification(notification);
    }
}
