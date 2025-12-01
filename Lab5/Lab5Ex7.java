//Write a program that can creates and runs multiple threads using Thread class.
//Let’s define 3 functions i.e.,
// a) find sum from 1 to n, 
// b) show all prime numbers in between 1 to 100, 
// c) read data from a CSV file of student list (name, ID, age, gender) and store it into an array list.

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Lab5Ex7 {

    static class SumThread extends Thread {
        private int n;

        SumThread(int n) {
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

    // Thread to display prime numbers from 1 to 100
    static class PrimeThread extends Thread {

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

    // Thread to read CSV file of students
    static class CSVThread extends Thread {
        private String fileName;
        private ArrayList<Student> students = new ArrayList<>();

        CSVThread(String fileName) {
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
        // 1) Sum from 1 to n
        Thread sumThread = new SumThread(50);

        // 2) Prime numbers
        Thread primeThread = new PrimeThread();

        // 3) Read CSV file (replace "students.csv" with your file path)
        Thread csvThread = new CSVThread("students.csv");

        // Start all threads
        sumThread.start();
        primeThread.start();
        csvThread.start();
    }
}
