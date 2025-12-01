import java.util.List;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


public class ReadCSVfp {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("person_list.csv");
        List<Person> people = Files.lines(path)
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Person(
                        parts[0],
                        Integer.parseInt(parts[1]),
                        parts[2]
                ))
                .toList();
        people.forEach(Person::display);
    }

    public static class Person {
        String name, city;
        int age;

        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public void display() {
            System.out.printf("%-20s %-5d %-20s%n", name, age, city);
        }

    }
}
