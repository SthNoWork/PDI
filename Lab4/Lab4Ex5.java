import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
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
        Storage.add("RITH CHANKOLBOTH,p2024...,m");
        Storage.add("PICH CHANVATANAK,p2024...,m");
        Storage.add("CHIV INTHERA,p2024...,f");

        FileWriter writer = new FileWriter(myFile);
        Collections.sort(Storage);

        for (int i = 0 ; i < Storage.size() ; i++) {
            writer.write(Storage.get(i) + "\n");
        }
        writer.close();
    }
}
