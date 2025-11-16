import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Ex1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int NumberOfBooks;
        int BookID;
        String BookTitle;
        int BookPrice;
        ArrayList<Lab3Ex1> Books = new ArrayList<Lab3Ex1>();

        NumberOfBooks = getValidatedInteger(input, "Please enter number of books: ");
        System.out.println();
        
        for (int i = 0 ; NumberOfBooks > i ; i++){
            BookID = getValidatedInteger(input, "Please enter book ID: ");
            BookTitle = getValidatedString(input, "Please enter book title: ");
            BookPrice = getValidatedInteger(input, "Please enter book price: ");

            Books.add(new Lab3Ex1 (BookID, BookTitle, BookPrice));
            System.out.println();
        }
        input.close();

        System.out.printf("%-10s %-20s %10s%n", "ID", "Title", "Price");
        for (Lab3Ex1 x : Books) {
            System.out.printf("%-10d %-20s %10d%n", x.BookID, x.BookTitle, x.BookPrice);
        }
        System.out.println();
    }

    int BookID;
    String BookTitle;
    int BookPrice;

    Lab3Ex1(){
    }
    Lab3Ex1(int BookID, String BookTitle, int BookPrice) {
        this.BookID = BookID;
        this.BookTitle = BookTitle;
        this.BookPrice = BookPrice;
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
}