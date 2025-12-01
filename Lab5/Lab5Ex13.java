
//Find max and min in an array using functional programming.
//int[ ] numbers = {5, 2, 9, 1, 3, 8};
//Hint: To find max, you can use the class IntStream and method max( ):
//IntStream.of(numbers).max();
import java.util.stream.IntStream;

public class Lab5Ex13 {
    public static void main(String[] args) {
        int[] numbers = { 5, 2, 9, 1, 3, 8};
        IntStream.of(numbers)
         .max()
         .ifPresent(System.out::println);
    }
}
