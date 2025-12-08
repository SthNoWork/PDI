// Abstract base class
abstract class Payment {
    abstract void processPayment(double amount);
}

// Child 1 — Credit Card
class CreditCardPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Verifying card number, checking balance...");
    }
}

// Child 2 — PayPal
class PayPalPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Connecting to PayPal account...");
    }
}

// Child 3 — Bank Transfer
class BankTransferPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing bank transfer of $" + amount);
        System.out.println("Verifying bank details and initiating transfer...");
    }
}

public class Lab6Ex7 {
    public static void main(String[] args) {

        // Create objects using abstract class reference
        Payment[] payments = {
            new CreditCardPayment(),
            new PayPalPayment(),
            new BankTransferPayment()
        };

        // Call processPayment on each one
        for (Payment p : payments) {
            p.processPayment(150.0);
            System.out.println("----------------------------------");
        }
    }
}
