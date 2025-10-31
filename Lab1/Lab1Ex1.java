// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class Lab1Ex1 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
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
            else if (Integer.parseInt(temp)>1000){
               System.out.println("Below 1000 only");
            }
            else {
               number = Integer.parseInt(temp);
               input.close();
               break;
            }
      }
      //prints 1000 to number
      for(int i = 1000; i >= number; --i) {
         System.out.print(i + " ");
         if (i%25 == 0){
            System.err.println();
         }
      }

      //calculate sum using formula
      int n = 1001 - number;
      int Sum = n / 2 * (1000 + number);
      double Average = (double)(1000 + number) / 2.0;

      //print
      System.out.println();
      System.out.println("Sum is: " + Sum);
      System.out.println("Average is: " + Average);
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
