//Write a procedural program to find the sum of even numbers from 1 to 100. Display result on screen.
public class Lab5Ex1 {

    public static int sumEven(int current, int max) {
        if (current > max) { 
            return 0;
        }

        int add = (current % 2 == 0) ? current : 0;
        return add + sumEven(current + 1, max);
    }
    public static void main(String[] args) {
        int max = 200; 
        int result = sumEven(1, max);
        System.out.println("Sum of even numbers from 1 to " + max + " = " + result);
    }
}
