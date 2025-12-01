import java.util.List;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

record Employee(String name, int age, String city) {
    @Override
    public String toString() {
        return "%-15s %-10s %d".formatted(name, city, age);
    }
}

public class ReadCSVfpV2 {
    public static void main(String[] args) throws IOException {
        List<Employee> employees = Files.lines(Paths.get("person_list.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Employee(
                        parts[0],
                        Integer.parseInt(parts[1]),
                        parts[2]))
                .toList();
        employees.forEach(System.out::println);
    }
}
