
//Read name of students from a CSV file then store in an array list.
//Print out name of students in a sorted A-Z order using functional programming.
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Lab5Ex12 {
    public static void main(String[] args) throws IOException{
        List<String> Students = new ArrayList<>();
        Files.lines(Paths.get("students.csv"))
        .map(lines -> lines.split(","))
        .map(parts -> parts[0])
        .sorted()
        .forEach(Students::add);
        Students.stream().forEach(System.out::println);
    }
}
