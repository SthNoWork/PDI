import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class Lab4Ex2 {
    public static void main(String[] args) throws IOException {
        Random RandomGenerator = new Random();
        Scanner input = new Scanner(System.in);
        int NumberOfFiles = getValidatedInteger(input, "Please enter number of files: ");
        FileWriter writer;
        File csvFolder = new File("Ex2LuckyNumber");
        csvFolder.mkdir();

        for (int i = 1; i <= NumberOfFiles; i++) {
            File myFile = new File(csvFolder, "file" + i + ".csv");
            writer = new FileWriter(myFile);
            writer.write(RandomGenerator.nextInt(1, 101) + "\n");
            writer.close();
        }

        ArrayList<Integer> Storage = new ArrayList<>();
        Scanner read;

        for (int i = 1; i <= NumberOfFiles; i++) {
            File myFile = new File(csvFolder, "file" + i + ".csv");
            read = new Scanner(myFile);
            Storage.add(read.nextInt());
            read.close();
        }

        System.out.println("Max: " + Collections.max(Storage));
        System.out.println("Min: " + Collections.min(Storage));
        
    }

    public static int getValidatedInteger(Scanner input, String prompt) {
        String temp;
        while (true) {
            System.out.print(prompt);

            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Error: Input cannot be blank or contain only spaces. Please try again.");
                continue;
            }

            try {
                int value = Integer.parseInt(temp);

                if (value <= 0) {
                    System.out.println("Error: Value must be greater than 0.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Error: Integer only! Input contains invalid characters.");
            }
        }
    }

}