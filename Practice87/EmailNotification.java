import java.util.List;

public class EmailNotification implements Notification {
    private final String subject;
    private final List<String> receivers;
    private final String message;

    public EmailNotification(String subject, List<String> receivers, String message) {
        this.subject = subject;
        this.receivers = receivers;
        this.message = "<p>" + message + "</p>";
    }

    @Override
    public String getFormattedMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getReceivers() {
        return receivers;
    }
}