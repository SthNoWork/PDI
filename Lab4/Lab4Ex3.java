import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab4Ex3 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        int NumberOfMembers = getValidatedInteger(input, "Please enter number of Members: ");

        File myFile = new File("Ex3StudentData.csv");
        FileWriter writer = new FileWriter(myFile);

        for (int i = 1; i <= NumberOfMembers; i++) {
            System.out.println();
            System.out.println ("Member " + i);
            String Name = getValidatedString(input, "Enter Name: ");
            String ID = getValidatedString(input, "Enter ID: ");
            String Gender = getValidatedString(input, "Ender Gender: ");
            writer.write(Name + "," + ID + "," + Gender + "\n");
        }
        writer.close();

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

    public static String getValidatedString(Scanner input, String prompt) {
        String temp;
        while (true) {
            System.out.print(prompt);

            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Error: Input cannot be blank or contain only spaces. Please try again.");
                continue;
            }
            return temp;
        }
    }

}