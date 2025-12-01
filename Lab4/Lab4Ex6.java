import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab4Ex6 {
    public static void main(String[] args) throws IOException {
        File myFile = new File("CandidatePerformanceTest.csv");
        Scanner reader = new Scanner(myFile);

        reader.nextLine();
        reader.nextLine();
        reader.nextLine();

        List<String[]> Storage = new ArrayList<>();

        while (reader.hasNextLine()) {
            Storage.add(reader.nextLine().split(","));
        }
        reader.close();

        Stats allCandidates = new Stats();

        allCandidates.getStats(Storage, (float) 1, 0);
        print("Total Candidates: ", allCandidates.total, allCandidates.male, allCandidates.female);

        allCandidates.getStats(Storage, (float) 90, 9);
        print("Total Candidates with an average score above 90: ", allCandidates.total, allCandidates.male,
                allCandidates.female);

        allCandidates.getStats(Storage, (float) 85, 5, 7);
        print("Total Candidates with each subject score at least 85: ", allCandidates.total, allCandidates.male,
                allCandidates.female);

        String[] group = { "A", "B", "C", "D", "E" };
        for (int i = 0; i < group.length; i++) {
            String Condition = "group " + group[i];
            allCandidates.getStats(Storage, Condition, 2);
            print("Total Group " + group[i] + ": ", allCandidates.total, allCandidates.male, allCandidates.female);
        }
    }

    /////////////////////////////////////////////////////////////////////
    public static void print(String title, int x, float y, float z) {
        System.out.println();
        System.out.println(title + x);
        System.out.println("% of Male: " + y * 100 / x);
        System.out.println("% of Female: " + z * 100 / x);
    }

    public static class Stats {
        int total;
        int male;
        int female;

        public void getStats(List<String[]> Storage, String Condition, int column) {
            total = 0;
            male = 0;
            female = 0;
            for (int i = 0; i < Storage.size(); i++) {
                if (Condition.equals(Storage.get(i)[column])) {
                    total++;
                    String Gender = Storage.get(i)[1];
                    if (Gender.equals("male")) {
                        male++;
                    } else if (Gender.equals("female")) {
                        female++;
                    }
                }
            }
        }

        public void getStats(List<String[]> Storage, float Condition, int column) {
            total = 0;
            male = 0;
            female = 0;

            for (int i = 0; i < Storage.size(); i++) {
                float value = Float.parseFloat(Storage.get(i)[column]);

                if (value >= Condition) {
                    total++;
                    String Gender = Storage.get(i)[1];

                    if (Gender.equals("male"))
                        male++;
                    else if (Gender.equals("female")) {
                        female++;
                    }
                }
            }
        }

        public void getStats(List<String[]> Storage, float Condition, int column1, int column2) {
            total = 0;
            male = 0;
            female = 0;

            for (int i = 0; i < Storage.size(); i++) {
                boolean atleast = true;
                for (int j = column1; j <= column2; j++) {
                    float value = Float.parseFloat(Storage.get(i)[j]);
                    if (value < Condition) { 
                        atleast = false;
                        break;
                    }
                }
                if (atleast) {
                    total++;
                    String Gender = Storage.get(i)[1];
                    if (Gender.equals("male"))
                        male++;
                    else if (Gender.equals("female")) {
                        female++;
                    }
                }
            }
        }

    }
}
