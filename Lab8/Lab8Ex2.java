// Problem 2- Open–Closed Principle (OCP)
// Given (Bad Design)
// class DiscountService {
//  double calculateDiscount(String discountType, double amount) {
//  if (discountType.equals("STUDENT")) {
//  return amount * 0.10;
//  }
//  else if (discountType.equals("FESTIVAL")) {
//  return amount * 0.20;
//  }
//  else if (discountType.equals("LOYAL")) {
//  return amount * 0.15;
//  }
//  return 0;
//  }
// }
// To-do Task:
// 1. Create an interface for discount calculation.
// 2. Create separate classes for each discount type.
// 3. Ensure:
// o No if-else in main service
// o New discount types can be added without modifying existing code
// 4. Each discount class must have:
// o At least 3 variables
// o At least 3 methods
interface calculateDiscount {
    double CalculateDiscount();
}

class Student implements calculateDiscount {
    public String name;
    public double price;
    public String discountType = "STUDENT";

    public Student(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double CalculateDiscount() {
        return price * 0.95;
    }

    public void displayPrice() {
        System.out.println(name + " with " + discountType + " discount is " + CalculateDiscount());
    }
}

class FESTIVAL implements calculateDiscount {
    public String name;
    public double price;
    public String discountType = "FESTIVAL";

    public FESTIVAL(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double CalculateDiscount() {
        return price * 0.9;
    }

    public void displayPrice() {
        System.out.println(name + " with " + discountType + " discount is " + CalculateDiscount());
    }
}

class LOYAL implements calculateDiscount {
    public String name;
    public double price;
    public String discountType = "LOYAL";

    public LOYAL(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double CalculateDiscount() {
        return price * 0.85;
    }

    public void displayPrice() {
        System.out.println(name + " with " + discountType + " discount is " + CalculateDiscount());
    }
}

public class Lab8Ex2 {
    public static void main(String[] args) {
        Student studentDiscount = new Student("Alice", 1000);
        FESTIVAL festivalDiscount = new FESTIVAL("Bob", 2000);
        LOYAL loyalDiscount = new LOYAL("Charlie", 1500);

        studentDiscount.displayPrice();
        festivalDiscount.displayPrice();
        loyalDiscount.displayPrice();
    }
}
