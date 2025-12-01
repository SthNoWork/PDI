
//Implement a calculator that supports basic arithmetic operations (+, -, *, /, sum from 1 to n) 
// using a menu-driven approach.
import java.util.*;

public class Lab5Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float result = 0;
        while (true) {
            System.out.println();
            System.out.println("Basic Calculator");
            System.out.println("1, +");
            System.out.println("2, -");
            System.out.println("3, *");
            System.out.println("4, /");
            System.out.println("5, to exit");
            System.out.println("Result = " + result);
            int option = getValidatedInteger(input, "Option: ");
            if (option == 5) {
                break;
            }
            System.out.println();
            float a = getValidatedFloat(input, "Enter first number: ");
            float b = getValidatedFloat(input, "Enter second number: ");

            switch (option) {
                case 1: {
                    result = a + b;
                    break;
                }
                case 2: {
                    result = a - b;
                    break;
                }
                case 3: {
                    result = a * b;
                    break;
                }
                case 4: {
                    result = a / b;
                    break;
                }
            }
        }
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
                int value = Integer.parseInt(temp);

                if (value < 1 || value > 5) {
                    System.out.println("Error: Value must be between 1 to 5.");
                    continue;
                }

                return value;

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
                continue;
            }

            try {
                return Float.parseFloat(temp);

            } catch (NumberFormatException e) {
                System.out.println("Error: Floating point number only! Input contains invalid characters.");
            }
        }
    }
}
