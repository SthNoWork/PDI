import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Ex6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int NumberOfAccounts;
        int AccountID;
        int AccountBalance;
        ArrayList<Lab3Ex6> Accounts = new ArrayList<Lab3Ex6>();

        NumberOfAccounts = getValidatedInteger(input, "Please enter number of Accounts: ");

        int i = 0;
        while (i < NumberOfAccounts) {
            System.out.println();
            AccountID = getValidatedInteger(input, "Please enter Account ID: ");

            // Check for duplicate
            boolean dupeAccount = false;
            for (Lab3Ex6 x : Accounts) {
                if (x.AccountID == AccountID) {
                    dupeAccount = true;
                    break; 
                }
            }

            if (dupeAccount) {
                System.out.println("Error: Account ID cannot be the same!");
                continue;
            }

            AccountBalance = getValidatedInteger(input, "Please enter Account Balance: ");
            Accounts.add(new Lab3Ex6(AccountID, AccountBalance));
            i++; // only increment when valid input
        }

        while (true) {
            int temp = getValidatedInteger(input, "\n0 :Exit\nEnter AccountID: ");

            if (temp == 0) {
                break;
            }
            boolean found = false;
            for (Lab3Ex6 x : Accounts) {
                if (x.AccountID == temp) {
                    found = true;
                    while (true) {
                        System.out.println();
                        System.out.printf("%-15s %-20s%n", "Account ID", "Balance");
                        System.out.printf("%-15d %-20d%n", x.AccountID, x.AccountBalance);
                        System.out.println("1 : Deposit");
                        System.out.println("2 : Withdraw");
                        System.out.println("3 : Back");

                        int option = getValidatedInteger(input, "Enter Option: ");

                        if (option == 1) {
                            float deposit = getValidatedFloat(input, "Enter deposit amount: ");
                            if (deposit > 0) {
                                x.AccountBalance += deposit;
                                System.out.println("Deposited " + deposit);
                                break;
                            } else {
                                System.out.println("Error: Value must be greater than 0!");
                            }
                        } else if (option == 2) {
                            float withdraw = getValidatedFloat(input, "Enter withdrawal amount: ");
                            if (withdraw > 0) {
                                x.AccountBalance -= withdraw;
                                System.out.println("Withdrawn " + withdraw);
                                break;
                            } else {
                                System.out.println("Error: Value must be greater than 0!");
                            }
                        } else if (option == 3) {
                            break;
                        } else {
                            System.out.println("Error: 1, 2 or 3 only!");
                        }
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Error: Account ID not found!");
                System.out.println();
            }
        }
        input.close();
        print(Accounts);
    }

    int AccountID;
    int AccountBalance;

    Lab3Ex6() {
    }

    Lab3Ex6(int AccountID, int AccountBalance) {
        this.AccountID = AccountID;
        this.AccountBalance = AccountBalance;
    }

    public static void print(ArrayList<Lab3Ex6> Accounts) {
        System.out.println();
        System.out.printf("%-15s %-20s%n", "Account ID", "Balance");
        for (Lab3Ex6 x : Accounts) {
            System.out.printf("%-15d %-20s%n", x.AccountID, x.AccountBalance);
        }
        System.out.println();
    }

    public static int getValidatedInteger(Scanner input, String prompt) {
        String temp;
        while (true) {
            System.out.print(prompt);

            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Error: Input cannot be blank or contain only spaces. Please try again.");
                continue;
            }

            try {
                return Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println("Error: Integer only! Input contains invalid characters.");
            }
        }
    }

    public static float getValidatedFloat(Scanner input, String prompt) {
        String temp;
        while (true) {
            System.out.print(prompt);

            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Error: Input cannot be blank or contain only spaces. Please try again.");
                System.out.println();
                continue;
            }

            try {
                return Float.parseFloat(temp);
            } catch (NumberFormatException e) {
                System.out.println("Error: Floating point number only! Input contains invalid characters.");
            }
        }
    }

    public static String getValidatedString(Scanner input, String prompt) {
        String temp;
        while (true) {
            System.out.print(prompt);

            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Error: Input cannot be blank or contain only spaces. Please try again.");
                continue;
            }
            return temp;
        }
    }
}