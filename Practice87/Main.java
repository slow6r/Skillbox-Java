import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание уведомлений
        EmailNotification email1 = new EmailNotification(
                "Успешная регистрация",
                List.of("oleg@java.skillbox.ru", "masha@java.skillbox.ru"),
                "Спасибо за регистрацию на сервисе!"
        );

        SmsNotification sms1 = new SmsNotification(
                List.of("+70001234567"),
                "Спасибо за регистрацию на сервисе!"
        );

        PushNotification push1 = new PushNotification(
                "Успешная регистрация",
                "o.yanovich",
                "Спасибо за регистрацию на сервисе!"
        );

        // Отправка через сервисы
        EmailNotificationSender emailSender = new EmailNotificationSender();
        emailSender.send(List.of(email1));

        SmsNotificationSender smsSender = new SmsNotificationSender();
        smsSender.send(List.of(sms1));

        PushNotificationSender pushSender = new PushNotificationSender();
        pushSender.send(List.of(push1));
    }
}