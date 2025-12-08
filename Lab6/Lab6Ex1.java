public class Lab6Ex1 {
    static class Vehicle {
        protected String brand;
        protected int year;

        public void start() {
            System.out.println(brand + " is starting...");
            System.out.println(year + " is so old");
        }

        public void getBrand() {
            System.out.println(brand);
        }
    }

    static class Car extends Vehicle {
        private int num_doors;

        Car(String brand, int year, int num_doors) {
            this.brand = brand;
            this.year = year;
            this.num_doors = num_doors;
        }

        public void honk() {
            System.out.println("MOVE IT!" + "YOU " + num_doors + " DOORS FREAK!");
        }
    }
    public static void main(String[] args) {
        Car car1 = new Car("Toyoda", 1967, 3);
        car1.start();
        car1.honk();

    }
}
