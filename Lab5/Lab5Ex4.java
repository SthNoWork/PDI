//Write a Java program to demonstrate a constructor by initializing attributes of an Employee class.
//Provide at least 5 attributes to describe an employee.
//Use private attributes in a class
//provide public getter and setter methods. Test your program in main.

public class Lab5Ex4 {
    static class Employee {
        private String name, ID, job;
        private int age;
        private double salary;

        Employee() {
            name = null;
            ID = null;
            job = null;
            age = 0;
            salary = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        String name = "Me";
        String ID = "p202400..";
        String job = "Vibe Coder";
        int age = 20;
        double salary = 0;

        Employee employee = new Employee();
        employee.setName(name);
        employee.setID(ID);
        employee.setJob(job);
        employee.setAge(age);
        employee.setSalary(salary);

        System.out.printf("%-20s %-20s %-20s %-5s %-15s%n",
                "Name", "ID", "Job", "Age", "Salary");

        System.out.printf("%-20s %-20s %-20s %-5d %-15.2f%n",
                employee.getName(), employee.getID(), employee.getJob(),
                employee.getAge(), employee.getSalary());

    }
}
