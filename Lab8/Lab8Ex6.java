/*
 * 1. Violated SOLID Principle:
 *    - Single Responsibility Principle (SRP): The original OrderService class handled
 *      too many distinct responsibilities: taking orders, calculating bills, saving orders,
 *      and sending emails. Each of these responsibilities has now been moved to a separate class.
 *
 * 2. Proposed Class Names:
 *    - OrderManager (Handles order operations: take, update, print)
 *    - BillingService (Handles bill calculation: apply tax, calculate, print)
 *    - OrderRepository (Handles database operations: save, delete, find)
 *    - EmailService (Handles notifications: send invoice, confirmation, reminder)
 */


class OrderManager {
    int orderId;
    String customerName;
    int quantity;

    void takeOrder() {
        System.out.println("Order taken");
    }

    void updateOrder() {
        System.out.println("Order updated");
    }

    void printOrder() {
        System.out.println("Order details printed");
    }
}

// BillingService.java
class BillingService {
    double price;
    double tax;
    double totalAmount;

    void calculateBill() {
        totalAmount = price + tax;
    }

    void applyTax() {
        tax = price * 0.10;
    }

    void printBill() {
        System.out.println("Total bill: " + totalAmount);
    }
}

// OrderRepository.java
class OrderRepository {
    int orderId;
    String databaseName;
    boolean isSaved;

    void saveOrder() {
        isSaved = true;
        System.out.println("Order saved");
    }

    void deleteOrder() {
        System.out.println("Order deleted");
    }

    void findOrder() {
        System.out.println("Order found");
    }
}

// EmailService.java
class EmailService {
    String senderEmail;
    String receiverEmail;
    String message;

    void sendInvoiceEmail() {
        System.out.println("Invoice email sent");
    }

    void sendConfirmation() {
        System.out.println("Confirmation email sent");
    }

    void sendReminder() {
        System.out.println("Reminder email sent");
    }
}

public class Lab8Ex6 {
    public static void main(String[] args) {

        OrderManager order = new OrderManager();
        order.orderId = 101;
        order.customerName = "Alice";
        order.quantity = 3;
        order.takeOrder();
        order.printOrder();

        BillingService billing = new BillingService();
        billing.price = 100;
        billing.applyTax();
        billing.calculateBill();
        billing.printBill();

        OrderRepository repo = new OrderRepository();
        repo.orderId = order.orderId;
        repo.databaseName = "OrdersDB";
        repo.saveOrder();

        EmailService email = new EmailService();
        email.senderEmail = "shop@example.com";
        email.receiverEmail = "alice@example.com";
        email.message = "Your order invoice";
        email.sendInvoiceEmail();
    }
}
