import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public void send(SmsNotification notification) {
        System.out.println("SMS");
        System.out.println("receivers: " + String.join(", ", notification.getPhoneNumbers()));
        System.out.println("message: " + notification.getFormattedMessage() + "\n");
    }

    @Override
    public void send(List<SmsNotification> notifications) {
        notifications.forEach(this::send);
    }
}