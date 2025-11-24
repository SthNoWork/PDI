import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Lab4Ex5 {
    public static void main(String[] args) throws IOException {
        File myFile = new File("Ex3StudentData.csv");
        Scanner read = new Scanner(myFile);
        ArrayList<String> Storage = new ArrayList<>();

        while (read.hasNextLine()) {
            Storage.add(read.nextLine());
        }
        read.close();
        Storage.add("Imaginary Member 1,4,M");
        Storage.add("Imaginary Member 2,5,M");
        Storage.add("Imaginary Member 3,6,M");

        FileWriter writer = new FileWriter(myFile);

        for (int i = 0 ; i < Storage.size() ; i++) {
            writer.write(Storage.get(i) + "\n");
        }
        writer.close();
    }
}
