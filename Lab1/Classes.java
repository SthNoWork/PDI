import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Classes  {
    // MyApp.java (The Clean Main Method)
    private static boolean IntegerChecker(String x) {
        try {
            Integer.parseInt(x);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    int number;
    String temp;
    while (true) {
        System.out.print("Enter a number: ");
        temp = input.nextLine();
        if (temp.isBlank()) {
            System.out.println("Stop spamming space/enter(s)!");
        }
        else if (!IntegerChecker(temp)){
            System.out.println("Integer inputs only!");
        }
        else if (Integer.parseInt(temp)){
            System.out.print("error message");
        }
        else {
            number = Integer.parseInt(temp);
            input.close();
            break;
        }
    }

    private static boolean DoubleChecker(String x) {
        try {
            Double.parseDouble(x);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    Double number;
    String temp;
    while (true) {
        System.out.print("Enter a number: ");
        temp = input.nextLine();
        if (temp.isBlank()) {
            System.out.println("Stop spamming space/enter(s)!");
        }
        else if (!DoubleChecker(temp)){
            System.out.println("Number inputs only!");
        }
        else if (Double.parseDouble(temp)){
            System.out.print("error message");
        }
        else {
            number = Double.parseDouble(temp);
            input.close();
            break;
        }
    }

    // how to read int or something like inputs 
    String temp;
    Double[] number = new double[size];
        while (true) {
            System.out.print("Input " + size + " : ");
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
}
