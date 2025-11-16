import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Ex4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int NumberOfStudents;
        int StudentID;
        String StudentName;
        String[] Subjects = { "Subject1", "Subject2", "Subject3", "Subject4", "Subject5" };
        float[] Scores = new float[Subjects.length];

        ArrayList<Lab3Ex4> Students = new ArrayList<Lab3Ex4>();

        NumberOfStudents = getValidatedInteger(input, "Please enter number of students: ");
        System.out.println();

        for (int i = 0; NumberOfStudents > i; i++) {
            StudentID = getValidatedInteger(input, "Please enter student ID: ");
            StudentName = getValidatedString(input, "Please enter student name: ");
            for (int j = 0; Subjects.length > j; j++) {
                Scores[j] = getValidatedFloat(input, "Please enter score for " + Subjects[j] + " : ");

            }
            Students.add(new Lab3Ex4(StudentID, StudentName, Scores));
            System.out.println();
        }
        input.close();

        for (Lab3Ex4 x : Students) {
            System.out.println("Student ID: " + x.StudentID);
            System.out.println("Student Name: " + x.StudentName);
            System.out.println("Scores:");

            float sum = 0;
            float avg = 0;
            for (int j = 0; Subjects.length > j; j++) {
                System.out.printf("%-15s %-5s %-10.2f%n", Subjects[j], " : ", x.Scores[j]);

                sum += x.Scores[j];
            }

            avg = sum/Subjects.length;
            System.out.println("Total Scores: " + sum);
            System.out.println("Average Score: " + avg);
            System.out.println("Grade: " + getGrade(avg));
        }
        System.out.println();
    }

    int StudentID;
    String StudentName;
    float[] Scores;

    Lab3Ex4() {
    }

    Lab3Ex4(int StudentID, String StudentName, float[] Scores) {
        this.StudentName = StudentName;
        this.StudentID = StudentID;
        this.Scores = Scores.clone();
    }

    public static char getGrade(float x) {
        if (x >= 90) {
            return 'A';
        } else if (x >= 75) {
            return 'B';
        } else if (x >= 50) {
            return 'C';
        } else {
            return 'F';
        }
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
                return Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println("Error: Integer only! Input contains invalid characters.");
            }
        }
    }

    public static float getValidatedFloat(Scanner input, String prompt) {
        String temp;
        while (true) {
            System.out.print(prompt);

            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Error: Input cannot be blank or contain only spaces. Please try again.");
                continue;
            }

            try {
                float value = Float.parseFloat(temp);

                if (value < 0 && value > 100) {
                    System.out.println("Error: Value must be 1-100!");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Error: Floating point number only! Input contains invalid characters.");
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