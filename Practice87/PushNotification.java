public class PushNotification implements Notification {
    private final String title;
    private final String userAccount;
    private final String message;

    public PushNotification(String title, String userAccount, String message) {
        this.title = title;
        this.userAccount = userAccount;
        this.message = "\ud83d\udc4b " + message;
    }

    @Override
    public String getFormattedMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getUserAccount() {
        return userAccount;
    }
}