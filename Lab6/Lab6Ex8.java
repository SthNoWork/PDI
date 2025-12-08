import java.util.ArrayList;

class Product {
    protected String name;
    protected double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getInfo() {
        return "Product: " + name + ", Price: $" + price;
    }
}

class Electronics extends Product {
    private int warrantyYears;

    Electronics(String name, double price, int warrantyYears) {
        super(name, price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    String getInfo() {
        return "Electronics → " + name + " | $" + price +
                " | Warranty: " + warrantyYears + " years";
    }
}

class Clothing extends Product {
    private String size;

    Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    String getInfo() {
        return "Clothing → " + name + " | $" + price +
                " | Size: " + size;
    }
}

class Book extends Product {
    private String author;

    Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    String getInfo() {
        return "Book → " + name + " | $" + price +
                " | Author: " + author;
    }
}

public class Lab6Ex8 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Electronics("Laptop", 850.0, 2));
        products.add(new Clothing("T-Shirt", 20.0, "L"));
        products.add(new Book("Harry Potter", 15.0, "J.K. Rowling"));

        for (Product p : products) {
            System.out.println(p.getInfo());
        }
    }
}
