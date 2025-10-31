import java.util.Scanner;

public class Lab1Ex2 {
    public static void main (String[] args){
        System.out.println("================================================");
        System.out.println("             Welcome to our program");
        System.out.println("'Quadratic Equation Solver ax² + bx + c = 0'");
        System.out.println("================================================");
        System.out.println();
        Scanner input = new Scanner(System.in);
        String temp;
        String abc = "abc";
        double[] number = new double[abc.length()];
        for (int i = 0 ; i < abc.length() ; i++ ) {
            while (true) {
                System.out.print("Input " + abc.charAt(i) + ": ");
                temp = input.nextLine();
                if (temp.isBlank()) {
                    System.out.println("Stop spamming space/enter(s)!");
                }
                else if (!DoubleChecker(temp)){
                    System.out.println("Number inputs only!");
                }
                else {
                    number[i] = Double.parseDouble(temp);
                    break;
                }
            }
        }
        input.close();

        System.out.println("------------------------------------------------");
        solver(number[0],number[1],number[2]);
        System.out.println("------------------------------------------------");
    }
    
    public static void solver (double a,double b,double c) {
        double delta = Math.pow(b,2) - 4*a*c;
        if (delta < 0) {
            System.out.println("The Equation only has imaginary roots");
        }
        else if (delta == 0) {
            double x = -b/(2*a);
            System.out.println("x = " + x);
        }
        else {
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
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
    
}