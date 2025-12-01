
//Use functional programming to filter out positive numbers from a given list and print them
import java.util.Arrays;
import java.util.List;

public class Lab5Ex10 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, -2, -6, -10);
        numbers.stream()
                .filter(x -> x > 0)
                .forEach(System.out::println);
    }
}
