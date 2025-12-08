public class Lab6Ex2 {
    static class Employee {
        protected String name;
        protected double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculate_bonus() {
            return salary * 0.1;
        }

        public void display() {
            System.out.println();
            System.out.println("name: " + name);
            System.out.println("salary: " + salary);
            System.out.println("bonus: " + calculate_bonus());
        }
    }

    static class Manager extends Employee {
        Manager(String name, double salary) {
            super(name, salary);
            // TODO Auto-generated constructor stub
        }

        public double calculate_bonus() {
            return salary * 0.2;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
            // TODO Auto-generated constructor stub
        }

        public double calculate_bonus() {
            return salary * 0.05;
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee("josh", 2000);
        Manager manager = new Manager("bob", 10000);
        Intern intern = new Intern("mark", 1000);

        employee.display();
        manager.display();
        intern.display();

    }
}
