import java.util.Scanner;

public class Lab1Ex4 {
    //Horrid jumble of codes but readable
    public static boolean checker(String date) {
        int year, month, day;
        if (date.length() != 10) {
            return false;
        }
        if (date.charAt(4) != '-' || date.charAt(7) != '-') {
            return false;
        }

        //check if its all numbers
        try {
            //string cutting
            String yearString = date.substring(0, 4);
            String monthString = date.substring(5, 7);
            String dayString = date.substring(8, 10);

            //converts the dates into int
            year = Integer.parseInt(yearString);
            month = Integer.parseInt(monthString);
            day = Integer.parseInt(dayString);

        //this checks if converting to int fails
        } catch (NumberFormatException e) {
            return false;
        } 
        
        //cant be negaitve check
        if (year < 0) {
            return false;
        }
        
        if (month < 1 || month > 12) {
            return false;
        }
        
        if (day < 1) {
            return false;
        }

        //Months with 31 and 30 check
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (day > 31) {
                    return false;
                }
            }
            case 4, 6, 9, 11 -> {
                if (day > 30) {
                    return false;
                }
            }
            case 2 -> {
                //Leap year stuff.
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    if (day > 29) {
                        return false;
                    }
                }
                else if (day > 28) {
                    return false;
                }
            }
        }
        return true; 
    }
    
    public static void main (String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input (yyyy-mm-dd): ");
        String date = input.nextLine();
        while (true) {
            if (checker(date)) {
                System.out.print("Output: valid\n");
                break;
            }
            else {
                System.out.print("Output: invalid\n");
                System.out.print("Input (yyyy-mm-dd): ");
                date = input.nextLine();
            }
        }
        input.close();
    }
}
