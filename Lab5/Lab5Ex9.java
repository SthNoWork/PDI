
//Write a functional program to find the cube of each number in a list and print the results
import java.util.Arrays;
import java.util.List;

public class Lab5Ex9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        numbers.stream()
                .map(x -> (int) Math.pow(x, 3))
                .forEach(System.out::println);
    }
}
