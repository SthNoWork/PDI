import java.util.Scanner;
import java.util.NoSuchElementException;

public class Lab1Ex3 {
    public static void main (String[] args) {
        // We will stick to 5 numbers, as requested
        int size = 5;
        double[] number = new double[size];
        String temp;
        
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Input " + size + " numbers: ");
            temp = input.nextLine();
            if (temp.isBlank()) {
                System.out.println("Stop spamming space/enter(s)!");
            }
            else {
                Scanner tempstring = new Scanner(temp);
                try {
                    for (int i = 0; i < size; i++) {
                        number[i] = tempstring.nextDouble();
                    }
                    tempstring.close();
                    break;
                }
                catch (NoSuchElementException e) {
                    System.out.println("Must input " + size + " numbers or numbers only!");
                }
            }
        }
        // Important: Close the scanner AFTER ALL input is finished
        input.close(); 

        // --- Finding Min and Max ---
        
        double min = number[0];
        double max = number[0];
        
        for (int i = 1; i < size; i++) {
            if (number[i] > max) { max = number[i]; }
            if (number[i] < min) { min = number[i]; }
        }
        
        // --- Output ---

        // Build a nice comma-separated list for the output
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < size; i++) {
            // Using String.format for clean decimal display
            list.append(String.format("%.2f", number[i]));
            if (i < size - 2) {
                list.append(", ");
            } else if (i == size - 2) {
                list.append(" and ");
            }
        }

        System.out.println("\n--- Results ---");
        System.out.println("Among all the " + size + " input numbers (" + list + ")");
        System.out.println("Minimum number is: " + min);
        System.out.println("Maximum number is: " + max);
    }
}
