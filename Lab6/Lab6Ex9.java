import java.util.Arrays;

public class Lab6Ex9 {
    abstract static class Transport {
        double distance;

        abstract double calculate_fare(double distance);

        void display_fare() {
            System.out.println(this.getClass().getSimpleName() + " fare: " + calculate_fare(distance));
        }
    }

    static class BusTransport extends Transport {
        double distance;

        BusTransport(double distance) {
            this.distance = distance;
        }

        double calculate_fare(double distance) {
            return distance * 1.5;
        }
    }

    static class MetroTransport extends Transport {
        double distance;

        MetroTransport(double distance) {
            this.distance = distance;
        }

        double calculate_fare(double distance) {
            return 10 + distance * 2;
        }
    }

    static class TaxiTransport extends Transport {
        double distance;

        TaxiTransport(double distance) {
            this.distance = distance;
        }

        double calculate_fare(double distance) {
            return 20 + distance * 5;
        }

        void display_fare() {
            System.out.println("Taxi fare: " + calculate_fare(0));
        }
    }

    public static void main(String[] args) {
        Transport[] transports = {
                new BusTransport(20),
                new MetroTransport(20),
                new TaxiTransport(20)
        };
        Arrays.stream(transports)
                .forEach(t -> t.display_fare());
    }
}
