//• Interface BankAccount.
// • Methods deposit() and withdraw().
// • Classes like SavingsAccount, CurrentAccount.
public class Lab7Ex4 {
    public interface BankAccount {
        void deposit(double amount);

        void withdraw(double amount);
    }

    public static class SavingsAccount implements BankAccount {
        double balance = 0;

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Too broke to withdraw " + amount + " from " + balance);
                
            }
        }
    }

    public static class CurrentAccount implements BankAccount {
        double balance = 0;

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        public void withdraw(double amount) {
            balance -= amount;
            if (balance < 0) {
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("In debt: " + balance);
            }
        }
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        CurrentAccount currentAccount = new CurrentAccount();
        savingsAccount.deposit(500);
        savingsAccount.withdraw(1000);
        currentAccount.deposit(100);
        currentAccount.withdraw(2000);
    }
}
