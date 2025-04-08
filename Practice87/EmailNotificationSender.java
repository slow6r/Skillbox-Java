import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    @Override
    public void send(EmailNotification notification) {
        System.out.println("EMAIL");
        System.out.println("subject: " + notification.getSubject());
        System.out.println("receivers: " + String.join(", ", notification.getReceivers()));
        System.out.println("message: " + notification.getFormattedMessage() + "\n");
    }

    @Override
    public void send(List<EmailNotification> notifications) {
        notifications.forEach(this::send);
    }
}