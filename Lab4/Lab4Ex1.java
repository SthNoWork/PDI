import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;;

public class Lab4Ex1 {
    public static void main(String[] args) throws IOException {
        Random RandomGenerator = new Random();
        File myFile = new File("Random.csv");
        FileWriter writer = new FileWriter(myFile);

        for (int i = 0; i < 100; i++) {
            writer.write(i + "," + "jonh" + "," + RandomGenerator.nextInt(0, 1000) + "\n");
        }
        writer.close();

        Scanner read = new Scanner(myFile);
        System.out.printf("%-10s %-20s %-10s%n", "Order", "Name", "Random");

        while (read.hasNextLine()) {
            String temp[] = read.nextLine().split(",");
            System.out.printf("%-10s %-20s %-10s%n", temp[0], temp[1], temp[2]);
        }
        read.close();
    }
}