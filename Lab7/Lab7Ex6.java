
// • Abstract class Vehicle.
// • Abstract methods calculateRent() and getVehicleType().
// • Concrete class: Car, Bike
// • Use abstract class to share properties such as vehicle number and brand.
// • Keep rent calculation abstract since pricing logic differs.
// • Add common validation (e.g., days > 0) in the abstract class.
// • The rental service should never depend on specific vehicle types.
import java.util.Scanner;

// -------------------- Abstract Vehicle --------------------
abstract class Vehicle {
    protected String vehicleNumber;
    protected String brand;

    public Vehicle(String vehicleNumber, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
    }

    protected void validateDays(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0");
        }
    }

    public abstract double calculateRent(int days);

    public abstract String getVehicleType();
}

// -------------------- Car --------------------
class Car extends Vehicle {

    private static final double RATE_PER_DAY = 50.0;

    public Car(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    @Override
    public double calculateRent(int days) {
        validateDays(days);
        return days * RATE_PER_DAY;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}

// -------------------- Bike --------------------
class Bike extends Vehicle {

    private static final double RATE_PER_DAY = 20.0;

    public Bike(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    @Override
    public double calculateRent(int days) {
        validateDays(days);
        return days * RATE_PER_DAY;
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }
}

// -------------------- Rental Service --------------------
class RentalService {

    public double rentVehicle(Vehicle vehicle, int days) {
        System.out.println("Vehicle Type: " + vehicle.getVehicleType());
        return vehicle.calculateRent(days);
    }
}

// -------------------- Main --------------------
public class Lab7Ex6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RentalService service = new RentalService();

        System.out.println("Choose Vehicle:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Vehicle vehicle;

        // Polymorphism in action
        if (choice == 1) {
            vehicle = new Car("CAR123", "Toyota");
        } else if (choice == 2) {
            vehicle = new Bike("BIKE456", "Yamaha");
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        int days;
        do {
            System.out.print("Enter rental days (> 0): ");
            days = sc.nextInt();

            if (days <= 0) {
                System.out.println("Invalid input. Try again.");
            }
        } while (days <= 0);

        double rent = service.rentVehicle(vehicle, days);
        System.out.println("Total Rent: $" + rent);

        sc.close();
    }
}
