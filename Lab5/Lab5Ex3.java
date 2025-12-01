//Create a class Book with attributes like title, author, and price.
//Define 2 constructors 
//one constructor override the default and set default values to data
//one constructor set info of a book).
//Include a method to display the book's details.
public class Lab5Ex3 {
    static class Book {
        private String title;
        private String author;
        private double price;

        public Book() {
            this.title = "Unknown";
            this.author = "Unknown";
            this.price = 0.0;
        }

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        public void display() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: $" + price);
        }
    }
    
    public static void main(String[] args) {
        String title = "PDI 101";
        String author = "Me";
        double price = 69;

        Book Details = new Book(title,author,price);
        Details.display();
    }
}
