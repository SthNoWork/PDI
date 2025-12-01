import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    String ID;
    String name;

    Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    void print() {
        System.out.println(ID + " " + name);
    }

    @Override
    public String toString() {
        return ID + " " + name;
    }
}

public class TestFPSort {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 10, 8, -90);

        List<Student> list = Arrays.asList(
            new Student("p20240034", "Sok"),
            new Student("p202400", "Sao"),
            new Student("3", "Dara"),
            new Student("4", "Daro"),
            new Student("5", "Panha")
        );

        System.out.println("\n--- 3. Numbers sorted (Ascending) ---");
        numbers.stream()
               .sorted()
               .forEach(System.out::println);

        System.out.println("\n--- 4. Numbers sorted (Descending) ---");
        numbers.stream()
               .sorted(Comparator.reverseOrder())
               .forEach(System.out::println);


        System.out.println("\n--- 5. Students sorted by Name (Ascending) ---");
        list.stream()
            .sorted(Comparator.comparing(n -> n.name))
            .forEach(Student::print);


        System.out.println("\n--- 6. Students sorted by ID (Ascending) ---");
        list.stream()
            .sorted(Comparator.comparing(n -> n.ID))
            .forEach(Student::print);


        System.out.println("\n--- 7. Students sorted by Name (Descending) ---");
        list.stream()
            .sorted(Comparator.comparing((Student s) -> s.name).reversed())
            .forEach(Student::print);


        System.out.println("\n--- 8. Students sorted by ID (Numeric) then Name (Alphabetical) ---");
        list.stream()
            .sorted(Comparator.comparingInt((Student s) -> Integer.parseInt(s.ID))
                      .thenComparing((Student s) -> s.name))
            .forEach(Student::print);
    }
}