import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Ex2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int NumberOfCities;
        String CityName;
        float Celsius;
        float Fahrenheit;
        ArrayList<Lab3Ex2> CityTemperature = new ArrayList<Lab3Ex2>();

        NumberOfCities = getValidatedInteger(input, "Please enter number of city: ");
        System.out.println();

        for (int i = 0; NumberOfCities > i; i++) {
            CityName = getValidatedString(input, "Please enter city name: ");
            Celsius = getValidatedFloat(input, "Please enter city temperature in celsius: ");
            Fahrenheit = (Celsius * 9 / 5) + 32;

            CityTemperature.add(new Lab3Ex2(CityName, Celsius, Fahrenheit));
            System.out.println();
        }
        input.close();

        System.out.printf("%-20s %-10s %10s%n", "City", "Celsius", "Fahrenheit");
        for (Lab3Ex2 x : CityTemperature) {
            System.out.printf("%-20s %-10.2f %10.2f%n", x.CityName, x.Celsius, x.Fahrenheit);
        }
        System.out.println();
    }

    String CityName;
    float Celsius;
    float Fahrenheit;

    Lab3Ex2() {
    }

    Lab3Ex2(String CityName, float Celsius, float Fahrenheit) {
        this.CityName = CityName;
        this.Celsius = Celsius;
        this.Fahrenheit = Fahrenheit;
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
}