package org.nameless.infra;

import org.nameless.core.notification.Notification;
import org.nameless.infra.notification.NotificationRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class NotificationJPARepositoryImpl implements NotificationRepository {
    private final NotificationJPARepository notificationJPARepository;

    public NotificationJPARepositoryImpl(@Lazy NotificationJPARepository notificationJPARepository) {
        this.notificationJPARepository = notificationJPARepository;
    }

    @Override
    public void saveNotification(Notification notification) {
        NotificationEntity notificationEntity = mapToEntity(notification);
        notificationEntity.setSender("nameless");
        notificationEntity.setSentAt(LocalDateTime.now());
        notificationJPARepository.save(notificationEntity);
    }

    private NotificationEntity mapToEntity(Notification notification) {
        return NotificationEntity.builder()
                .toCustomerId(notification.toCustomerId())
                .toCustomerEmail(notification.toCustomerEmail())
                .sender(notification.sender())
                .sentAt(notification.sentAt())
                .message(notification.message())
                .build();
    }

    private Notification mapToDomainModel(Notification notification) {
        return Notification.builder()
                .notificationId(notification.notificationId())
                .toCustomerId(notification.toCustomerId())
                .toCustomerEmail(notification.toCustomerEmail())
                .sender(notification.sender())
                .sentAt(notification.sentAt())
                .message(notification.message())
                .build();
    }
}
