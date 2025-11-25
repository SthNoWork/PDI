import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4Ex4 {
    public static void main(String[] args) throws IOException {
        File myFile = new File("Ex3StudentData.csv");
        Scanner read = new Scanner(myFile);
        ArrayList<String> Storage = new ArrayList<>();

        while (read.hasNextLine()) {
            Storage.add(read.nextLine());
        }
        read.close();

        System.out.printf("%-20s %-20s %-5s%n", "Name", "ID", "Gender");
        for (int i = 0; i < Storage.size(); i++) {
            String temp[] = Storage.get(i).split(",");
            System.out.printf("%-20s %-20s %-5s%n", temp[0], temp[1], temp[2]);
        }
    }
}