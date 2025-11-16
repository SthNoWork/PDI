import java.util.Scanner;
import java.util.ArrayList;

public class Lab3Ex5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int NumberOfItems;
        int ItemID;
        String ItemName;
        int ItemQuantity;
        float ItemPrice;

        ArrayList<Lab3Ex5> Items = new ArrayList<Lab3Ex5>();

        NumberOfItems = getValidatedInteger(input, "Please enter number of items: ");
        System.out.println();

        for (int i = 0; NumberOfItems > i; i++) {
            ItemName = getValidatedString(input, "Please enter item name: ");
            ItemID = getValidatedInteger(input, "Please enter item ID: ");
            ItemQuantity = getValidatedInteger(input, "Please enter item quantity: ");
            ItemPrice = getValidatedFloat(input, "Please enter item price: ");

            float ItemTotalCost = ItemPrice * ItemQuantity;
            Items.add(new Lab3Ex5(ItemName, ItemID, ItemQuantity, ItemPrice, ItemTotalCost));
            System.out.println();
        }
        input.close();

        System.out.printf("%-15s %-20s %-15s %-15s %-15s%n", "Item ID", "Name", "Quantity", "Price", "Total Cost");
        for (Lab3Ex5 x : Items) {
            System.out.printf("%-15s %-20s %-15s %-15s %-15s%n",
                    x.ItemName, x.ItemID, x.ItemQuantity, x.ItemPrice, x.ItemTotalCost);
        }
        System.out.println();
    }

    String ItemName;
    int ItemID;
    float ItemQuantity;
    float ItemPrice;
    float ItemTotalCost;

    Lab3Ex5() {
    }

    Lab3Ex5(String ItemName, int ItemID, float ItemQuantity, float ItemPrice, float ItemTotalCost) {
        this.ItemName = ItemName;
        this.ItemID = ItemID;
        this.ItemQuantity = ItemQuantity;
        this.ItemPrice = ItemPrice;
        this.ItemTotalCost = ItemTotalCost;
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
                int value = Integer.parseInt(temp);

                if (value < 0) {
                    System.out.println("Error: Value must be 0 or above!");
                    continue;
                }

                return value;

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
                float value = Float.parseFloat(temp);

                if (value <= 0) {
                    System.out.println("Error: Value must be greater than 0!");
                    continue;
                }

                return value;

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