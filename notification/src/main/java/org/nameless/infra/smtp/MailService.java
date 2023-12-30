package org.nameless.infra.smtp;

import org.nameless.core.notification.Notification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender sender;

    public MailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(notification.sender());
        message.setTo(notification.toCustomerEmail());
        message.setSubject(notification.subject());
        message.setText(notification.message());
        sender.send(message);
    }
}
