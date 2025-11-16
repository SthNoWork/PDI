import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Ex3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int NumberOfEmployees;
        int EmployeeID;
        String EmployeeName;
        float BasicSalary;
        float GrossSalary;

        ArrayList<Lab3Ex3> Employees = new ArrayList<Lab3Ex3>();

        NumberOfEmployees = getValidatedInteger(input, "Please enter number of employee: ");
        System.out.println();

        for (int i = 0; NumberOfEmployees > i; i++) {
            EmployeeName = getValidatedString(input, "Please enter employee name: ");
            EmployeeID = getValidatedInteger(input, "Please enter employee ID: ");
            BasicSalary = getValidatedFloat(input, "Please enter basic salary: ");
            GrossSalary = (float) (BasicSalary*1.3);
            Employees.add(new Lab3Ex3(EmployeeName, EmployeeID, BasicSalary,GrossSalary));
            System.out.println();
        }
        input.close();

        System.out.printf("%-15s %-20s %-15s %-15s%n", "Employee ID", "Name", "Basic Salary", "Gross Salary");
        for (Lab3Ex3 x : Employees) {
            System.out.printf("%-15s %-20s %-15.2f %-15.2f%n", x.EmployeeID, x.EmployeeName, x.BasicSalary, x.GrossSalary);
        }
        System.out.println();
    }

    String EmployeeName;
    int EmployeeID;
    float BasicSalary;
    float GrossSalary;
    Lab3Ex3() {
    }

    Lab3Ex3(String EmployeeName, int EmployeeID, float BasicSalary, float GrossSalary) {
        this.EmployeeName = EmployeeName;
        this.EmployeeID = EmployeeID;
        this.BasicSalary = BasicSalary;
        this.GrossSalary = GrossSalary;
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
                return Float.parseFloat(temp);
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