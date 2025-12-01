
//Using functional programming to sort data in a list.
// Sample data
//Hint:Use sorted()method in the stream.numbers.stream().sorted()
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lab5Ex11 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, -1, 3, -8, 20, -50);
        System.out.println("ascending");
        numbers.stream().sorted().forEach(System.out::println);
        System.out.println("descending");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
