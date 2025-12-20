// • Create an interface Notification.
// • Declare a method sendMessage(String message).
// • Implement this interface in EmailNotification, SMSNotification, and PushNotification.
// • Select notification type dynamically at runtime.

import java.util.Scanner;

// -------------------- Interface --------------------
interface Notification {
    void sendMessage(String message);
}

// -------------------- Email Notification --------------------
class EmailNotification implements Notification {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending EMAIL notification: " + message);
    }
}

// -------------------- SMS Notification --------------------
class SMSNotification implements Notification {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

// -------------------- Push Notification --------------------
class PushNotification implements Notification {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending PUSH notification: " + message);
    }
}

// -------------------- Main --------------------
public class Lab7Ex7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Notification Type:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // clear buffer

        Notification notification; // interface reference

        // Runtime selection
        if (choice == 1) {
            notification = new EmailNotification();
        } else if (choice == 2) {
            notification = new SMSNotification();
        } else if (choice == 3) {
            notification = new PushNotification();
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        // Polymorphic call
        notification.sendMessage(message);

        sc.close();
    }
}
