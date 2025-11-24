import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;;

public class Lab4Ex1 {
    public static void main(String[] args) throws IOException {
        Random RandomGenerator = new Random();
        File myFile = new File(" LuckyNumber.csv");
        FileWriter writer = new FileWriter(myFile);

        for (int i = 0; i < 500; i++) {
            writer.write(RandomGenerator.nextInt(0, 1000) + " ");
        }
        writer.close();

        Scanner read = new Scanner(myFile);

        while (read.hasNextInt()) {
            System.out.println(read.nextInt());
        }
        read.close();
    }
}