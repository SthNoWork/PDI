abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String accountType;

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);
}

class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance, "Savings");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class FixedDepositAccount extends Account {
    private boolean matured;

    public FixedDepositAccount(String accountNumber, double balance, boolean matured) {
        super(accountNumber, balance, "Fixed Deposit");
        this.matured = matured;
    }

    @Override
    public void withdraw(double amount) {
        if (matured) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Invalid amount or insufficient balance.");
            }
        } else {
            System.out.println("Cannot withdraw until maturity.");
        }
    }

    public void setMatured(boolean matured) {
        this.matured = matured;
    }
}

public class Lab8Ex3 {
    public static void main(String[] args) {

        Account savings = new SavingsAccount("S001", 1000);
        Account fixed = new FixedDepositAccount("F001", 5000, false);

        savings.withdraw(200);
        System.out.println("Savings balance: " + savings.getBalance());

        fixed.withdraw(1000); // restricted
        System.out.println("Fixed balance: " + fixed.getBalance());

        ((FixedDepositAccount) fixed).setMatured(true);
        fixed.withdraw(1000); // now allowed
        System.out.println("Fixed balance after maturity: " + fixed.getBalance());

        // Deposit example
        savings.deposit(500);
        System.out.println("Savings balance after deposit: " + savings.getBalance());
    }
}
