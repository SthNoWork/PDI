public class Lab11Ex6 {
    static class Car {
        String vin, model;
        int year;
        double price;
        String engineType;

        Car(String vin, String model, int year, double price, String engineType) {
            this.vin = vin;
            this.model = model;
            this.year = year;
            this.price = price;
            this.engineType = engineType;
        }

        public String toString() {
            return vin + ", " + model + ", " + year + ", " + price + ", " + engineType;
        }
    }

    public static void main(String[] args) {
        Car[] cars = new Car[] {
                new Car("VIN1", "ModelA", 2018, 20000, "V6"),
                new Car("VIN2", "ModelB", 2020, 30000, "V8"),
                new Car("VIN3", "ModelC", 2015, 15000, "I4"),
                new Car("VIN4", "ModelD", 2021, 45000, "Electric"),
                new Car("VIN5", "ModelE", 2019, 25000, "I4"),
                new Car("VIN6", "ModelF", 2017, 12000, "I4"),
                new Car("VIN7", "ModelG", 2016, 18000, "V6"),
                new Car("VIN8", "ModelH", 2022, 55000, "Electric"),
                new Car("VIN9", "ModelI", 2014, 9000, "I4"),
                new Car("VIN10", "ModelJ", 2013, 8000, "I3")
        };
        selectionSortByPriceDesc(cars);
        for (Car c : cars)
            System.out.println(c);
    }

    static void selectionSortByPriceDesc(Car[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++)
                if (a[j].price > a[max].price)
                    max = j;
            Car t = a[i];
            a[i] = a[max];
            a[max] = t;
        }
    }
}
