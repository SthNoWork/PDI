import java.util.*;
import java.util.function.*;

public class calc {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Functional operations
        DoubleBinaryOperator add = (a, b) -> a + b;
        DoubleBinaryOperator sub = (a, b) -> a - b;
        DoubleBinaryOperator mul = (a, b) -> a * b;
        DoubleBinaryOperator div = (a, b) -> b == 0 ? Double.NaN : a / b;

        // Sum 1 to n using IntUnaryOperator
        IntUnaryOperator sumToN = n -> n < 1 ? 0 : (n * (n + 1)) / 2;

        // Menu actions using Runnable
        Map<Integer, Runnable> actions = new LinkedHashMap<>();

        actions.put(1, () -> {
            double[] nums = readTwoNumbers(input);
            System.out.println("Result = " + add.applyAsDouble(nums[0], nums[1]));
        });

        actions.put(2, () -> {
            double[] nums = readTwoNumbers(input);
            System.out.println("Result = " + sub.applyAsDouble(nums[0], nums[1]));
        });

        actions.put(3, () -> {
            double[] nums = readTwoNumbers(input);
            System.out.println("Result = " + mul.applyAsDouble(nums[0], nums[1]));
        });

        actions.put(4, () -> {
            double[] nums = readTwoNumbers(input);
            double result = div.applyAsDouble(nums[0], nums[1]);
            if (Double.isNaN(result)) {
                System.out.println("Error: Cannot divide by zero.");
            } else {
                System.out.println("Result = " + result);
            }
        });

        actions.put(5, () -> {
            System.out.print("Enter n: ");
            int n = input.nextInt();
            System.out.println("Sum from 1 to " + n + " = " + sumToN.applyAsInt(n));
        });

        int choice;
        do {
            printMenu();
            choice = input.nextInt();

            if (actions.containsKey(choice)) {
                actions.get(choice).run();
            } else if (choice != 0) {
                System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        System.out.println("Goodbye!");
    }

    // Helper method to read two numbers
    private static double[] readTwoNumbers(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        return new double[] { a, b };
    }

    // Menu printing
    private static void printMenu() {
        System.out.println("\n===== FUNCTIONAL CALCULATOR =====");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Sum 1 to n");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }
}
