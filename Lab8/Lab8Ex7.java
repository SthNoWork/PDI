interface Notification {
    void send();
    boolean validate();
    void logNotification();
}

class EmailNotification implements Notification {
    String recipient;
    String message;
    String timestamp;

    EmailNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = "2025-12-29 10:00";
    }

    public void send() {
        if (validate()) {
            System.out.println("Email sent to " + recipient + ": " + message);
            logNotification();
        } else {
            System.out.println("Invalid email notification");
        }
    }

    public boolean validate() {
        return recipient.contains("@") && !message.isEmpty();
    }

    public void logNotification() {
        System.out.println("Email logged at " + timestamp);
    }
}

class SMSNotification implements Notification {
    String recipient;
    String message;
    String timestamp;

    SMSNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = "2025-12-29 10:01";
    }

    public void send() {
        if (validate()) {
            System.out.println("SMS sent to " + recipient + ": " + message);
            logNotification();
        } else {
            System.out.println("Invalid SMS notification");
        }
    }

    public boolean validate() {
        return recipient.matches("\\d{10}") && !message.isEmpty();
    }

    public void logNotification() {
        System.out.println("SMS logged at " + timestamp);
    }
}

class PushNotification implements Notification {
    String recipient;
    String message;
    String timestamp;

    PushNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = "2025-12-29 10:02";
    }

    public void send() {
        if (validate()) {
            System.out.println("Push notification sent to " + recipient + ": " + message);
            logNotification();
        } else {
            System.out.println("Invalid push notification");
        }
    }

    public boolean validate() {
        return !recipient.isEmpty() && !message.isEmpty();
    }

    public void logNotification() {
        System.out.println("Push notification logged at " + timestamp);
    }
}

class NotificationService {
    void sendNotification(Notification notification) {
        notification.send();
    }
}

public class Lab8Ex7 {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Notification email = new EmailNotification("alice@example.com", "Your order has shipped");
        Notification sms = new SMSNotification("0123456789", "Your OTP is 123456");
        Notification push = new PushNotification("user123", "You have a new message");

        service.sendNotification(email);
        service.sendNotification(sms);
        service.sendNotification(push);
    }
}
