package org.nameless.infra.notification;

import org.nameless.core.notification.Notification;

public interface NotificationRepository {
    void saveNotification(Notification notification);
}
