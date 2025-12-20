// • Create an interface Payment.
// • Create an abstract class OnlinePayment that implements Payment.
// • Implement common methods such as validateUser() and generateReceipt().
// • Create concrete classes like CreditCardPayment and PaypalPayment.

import java.util.Scanner;

// -------------------- Interface --------------------
interface Payment {
    void pay(double amount);  // abstract payment method
}

// -------------------- Abstract Class --------------------
abstract class OnlinePayment implements Payment {
    
    protected String username;

    public OnlinePayment(String username) {
        this.username = username;
    }

    // Common method: validate user
    public boolean validateUser() {
        // simple validation for example
        if (username == null || username.isEmpty()) {
            System.out.println("Invalid user!");
            return false;
        }
        System.out.println("User validated: " + username);
        return true;
    }

    // Common method: generate receipt
    public void generateReceipt(double amount) {
        System.out.println("Receipt: Payment of $" + amount + " by " + username);
    }

    // Abstract method: specific payment steps
    public abstract void processPayment(double amount);
    
    // pay() implements interface
    @Override
    public void pay(double amount) {
        if (validateUser()) {
            processPayment(amount);       // specific to gateway
            generateReceipt(amount);      // common receipt
        } else {
            System.out.println("Payment failed due to invalid user.");
        }
    }
}

// -------------------- Concrete Classes --------------------
class CreditCardPayment extends OnlinePayment {

    public CreditCardPayment(String username) {
        super(username);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + "...");
        // Here you could add logic like checking card number, etc.
    }
}

class PaypalPayment extends OnlinePayment {

    public PaypalPayment(String username) {
        super(username);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + "...");
        // Logic specific to PayPal API
    }
}

// -------------------- Main --------------------
public class Exercise8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();

        OnlinePayment payment;

        // Runtime selection (polymorphism)
        if (choice == 1) {
            payment = new CreditCardPayment(username);
        } else if (choice == 2) {
            payment = new PaypalPayment(username);
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        // Polymorphic call
        payment.pay(amount);

        sc.close();
    }
}
