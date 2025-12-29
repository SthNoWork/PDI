interface Payment {
    void pay(double amount);

    void refund();

    String getStatus();
}

class PayPal implements Payment {
    private String transactionId;
    private double amount;
    private String status;

    @Override
    public void pay(double amount) {
        this.amount = amount;
        this.transactionId = "Receipt" + Math.random();
        this.status = "Success";
        System.out.println("Payment of " + amount + " processed via PayPal.");
    }

    @Override
    public void refund() {
        this.status = "Refunded";
        System.out.println("Refund processed for PayPal transaction: " + transactionId);
    }

    @Override
    public String getStatus() {
        return this.status;
    }
}

class CreditCard implements Payment {
    private String transactionId;
    private double amount;
    private String status;

    @Override
    public void pay(double amount) {
        this.amount = amount;
        this.transactionId = "TXN_CC_" + Math.random();
        this.status = "Success";
        System.out.println("Payment of " + amount + " processed via Credit Card.");
    }

    @Override
    public void refund() {
        this.status = "Refunded";
        System.out.println("Refund processed for Credit Card transaction: " + transactionId);
    }

    @Override
    public String getStatus() {
        return this.status;
    }
}

class ShoppingCart {
    private Payment payment;

    public ShoppingCart(Payment payment) {
        this.payment = payment;
    }

    public void checkout(double amount) {
        payment.pay(amount);
    }
}

public class Lab8Ex5 {
    public static void main(String[] args) {
        Payment paypal = new PayPal();
        ShoppingCart cart1 = new ShoppingCart(paypal);
        cart1.checkout(500.0);
        System.out.println("Status: " + paypal.getStatus());
        paypal.refund();
        System.out.println("Status: " + paypal.getStatus());

        System.out.println("--------------------");

        Payment creditCard = new CreditCard();
        ShoppingCart cart2 = new ShoppingCart(creditCard);
        cart2.checkout(1200.50);
        System.out.println("Status: " + creditCard.getStatus());
        creditCard.refund();
        System.out.println("Status: " + creditCard.getStatus());
    }
}