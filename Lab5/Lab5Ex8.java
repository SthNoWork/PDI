//Redesign the problem in Exercise 7 by using Runnable task instead
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Lab5Ex8 {

    static class SumTask implements Runnable {
        private int n;

        SumTask(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("Sum from 1 to " + n + " = " + sum);
        }
    }

    static class PrimeTask implements Runnable {
        @Override
        public void run() {
            System.out.print("Primes from 1 to 100: ");
            for (int i = 2; i <= 100; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        private boolean isPrime(int num) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        }
    }

    // 3) CSV reading task
    static class CSVTask implements Runnable {
        private String fileName;
        private ArrayList<Student> students = new ArrayList<>();

        CSVTask(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String name = parts[0].trim();
                        String id = parts[1].trim();
                        int age = Integer.parseInt(parts[2].trim());
                        String gender = parts[3].trim();
                        students.add(new Student(name, id, age, gender));
                    }
                }

                System.out.println("Students read from CSV:");
                for (Student s : students) {
                    System.out.println(s);
                }

            } catch (Exception e) {
                System.out.println("Error reading CSV: " + e.getMessage());
            }
        }
    }

    // Student class
    static class Student {
        private String name, id, gender;
        private int age;

        Student(String name, String id, int age, String gender) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return name + ", " + id + ", " + age + ", " + gender;
        }
    }

    // MAIN
    public static void main(String[] args) {
        // Create Runnable tasks
        Runnable sumTask = new SumTask(50);
        Runnable primeTask = new PrimeTask();
        Runnable csvTask = new CSVTask("students.csv"); // replace with your CSV path

        // Create Threads with the tasks
        Thread t1 = new Thread(sumTask);
        Thread t2 = new Thread(primeTask);
        Thread t3 = new Thread(csvTask);

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}
