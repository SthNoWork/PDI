import java.util.Scanner;

public class Lab1Ex5 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number;
    String temp;
    while (true) {
        System.out.print("Input n: ");
        temp = input.nextLine();
        if (temp.isBlank()) {
            System.out.println("Stop spamming space/enter(s)!");
        }
        else if (!IntegerChecker(temp)){
            System.out.println("Integer inputs only!");
        }
        else {
            number = Integer.parseInt(temp);
            break;
        }
    }
    input.close();
    if (isPrime(number)) {
        System.out.print("All prime numbers from 2 to " + number + ": ");
        for (int i = 0 ; i <= number ; i++) {
            System.out.print(i + " ");
        }
        System.err.println();
    }
    else {
        System.out.println(number + " is not a prime number!");
    }
}

    private static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean IntegerChecker(String x) {
        try {
            Integer.parseInt(x);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}