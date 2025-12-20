//• Abstract class Employee.
//• Abstract method calculateSalary().
// • Subclasses like Developer, Manager.

import java.util.Arrays;

public class Lab7Ex5 {
    abstract static class Employee {
        protected String employeeName, employeeID;
        protected double salary;

        abstract double calculateSalary();
    }

    public static class Developer extends Employee {
        Developer(String employeeName, String employeeID, double salary) {
            this.employeeName = employeeName;
            this.employeeID = employeeID;
            this.salary = salary;
        }

        @Override
        double calculateSalary() {
            return salary * 1.2;
        }
    }

    public static class Manager extends Employee {
        Manager(String employeeName, String employeeID, double salary) {
            this.employeeName = employeeName;
            this.employeeID = employeeID;
            this.salary = salary;
        }

        @Override
        double calculateSalary() {
            return salary * 1.25;
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Developer("jake", "01", 1000),
                new Manager("Jacon", "02", 1000)
        };
        Arrays.stream(employees).forEach(x -> {
            System.out.println(x.getClass().getSimpleName() + ": " + x.employeeName);
            System.out.println("Salary: " + x.calculateSalary());
        });
    }
}
