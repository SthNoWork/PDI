package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// The Student class definition
class Student {
    // Note: Assuming 'ID' is an integer in the main method usage, but defined as String here.
    // Adjusting 'ID' to String based on the class definition in the image.
    String ID;
    String name;

    // Constructor to initialize Student
    Student(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    // Method to print student details
    void print() {
        // The original image uses System.out.println(ID + name); which is ambiguous.
        // I'll make it clearer for standard Java output.
        System.out.println(ID + " " + name);
    }

    // Optional: Overriding toString for cleaner printing with stream::forEach(System.out::println)
    @Override
    public String toString() {
        return ID + " " + name;
    }
}

// Main class to demonstrate sorting using functional programming
public class TestFPSort {
    public static void main(String[] args) {
        // 1. Setup the list of Integer numbers
        List<Integer> numbers = Arrays.asList(1, 4, 5, 10, 8, -90);

        // 2. Setup the list of Student objects
        List<Student> list = Arrays.asList(
            new Student("10", "Sok"),
            new Student("20", "Sao"),
            new Student("3", "Dara"),
            new Student("4", "Daro"),
            new Student("5", "Panha")
        );

        // --- Demonstrations from the image ---

        // 3. Sort numbers naturally (ascending)
        System.out.println("\n--- 3. Numbers sorted (Ascending) ---");
        numbers.stream()
               .sorted()
               .forEach(System.out::println);

        // 4. Sort numbers in reverse order (descending)
        System.out.println("\n--- 4. Numbers sorted (Descending) ---");
        numbers.stream()
               .sorted(Comparator.reverseOrder())
               .forEach(System.out::println);


        // 5. Sort list of Students by name (n.name) naturally (Ascending)
        System.out.println("\n--- 5. Students sorted by Name (Ascending) ---");
        list.stream()
            .sorted(Comparator.comparing(n -> n.name))
            .forEach(Student::print);


        // 6. Sort list of Students by ID (n.ID) naturally (Ascending)
        System.out.println("\n--- 6. Students sorted by ID (Ascending) ---");
        list.stream()
            .sorted(Comparator.comparing(n -> n.ID))
            .forEach(Student::print); // Note: Since ID is String, "10" comes before "3"


        // 7. Sort list of Students by name in reverse order (Descending)
        System.out.println("\n--- 7. Students sorted by Name (Descending) ---");
        list.stream()
            .sorted(Comparator.comparing((Student s) -> s.name).reversed())
            .forEach(Student::print);


        // 8. Sort list of Students first by ID (as Integer) then by name (String)
        // Note: The original image used comparingInt but on a String field, which is not direct.
        // We assume the user intended to compare the ID values numerically, so we parse it to Integer.
        System.out.println("\n--- 8. Students sorted by ID (Numeric) then Name (Alphabetical) ---");
        list.stream()
            .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.ID)) // Sort numerically by ID
                      .thenComparing(s -> s.name))                    // Then sort alphabetically by name
            .forEach(Student::print);
    }
}