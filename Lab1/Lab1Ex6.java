import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab1Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] subjects = { "Math", "English", "Physics", "Programming" };
        int size = subjects.length;
        int[] scores = new int[size];
        String temp;
        while (true) {
            System.out.print("Input your scores of 4 subjects (Math, English, Physics, and Programming): ");
            temp = input.nextLine();

            if (temp.isBlank()) {
                System.out.println("Stop spamming space/enter(s)!");
            }
            else {
                Scanner tempstring = new Scanner(temp);
                try {
                    for (int i = 0; i < size; i++) {
                        scores[i] = tempstring.nextInt();
                    }
                    tempstring.close();
                    break;
                }
                catch (NoSuchElementException e) {
                    System.out.println("Must input " + size + " numbers or numbers only!");
                }
            }
        }

        input.close();
        // Find max and min
        int max = scores[0];
        int min = scores[0];
        double sum = scores[0];

        for (int i = 1; i < size; i++) {
            if (scores[i] > max)
                max = scores[i];
            if (scores[i] < min)
                min = scores[i];
            sum += scores[i];
        }
        // Find subjects with max score
        ArrayList<String> maxSubjects = new ArrayList<>();
        ArrayList<String> minSubjects = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (scores[i] == max)
                maxSubjects.add(subjects[i]);
            if (scores[i] == min)
                minSubjects.add(subjects[i]);
        }
        // Print max score and subjects
        System.out.print("Max score is: " + max + " (");
        printSubjects(maxSubjects);
        System.out.println(maxSubjects.size() > 1 ? " courses)." : " course).");

        // Print min score and subjects
        System.out.print("Min score is: " + min + " (");
        printSubjects(minSubjects);
        System.out.println(minSubjects.size() > 1 ? " courses)." : " course).");

        // Print average
        double average = sum / size;
        System.out.println("Average score of this student is: " + average);
    }

    private static void printSubjects(ArrayList<String> subjects) {
        int n = subjects.size();
        for (int i = 0; i < n; i++) {
            System.out.print(subjects.get(i));
            if (i < n - 2) {
                System.out.print(", ");
            } else if (i == n - 2) {
                System.out.print(" and ");
            }
        }
    }
}
