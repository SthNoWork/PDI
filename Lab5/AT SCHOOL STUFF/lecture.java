import java.util.Arrays;

public class lecture {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
