package exception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ExceptionHandler {

    // Method to validate the amount (accepts both integer-like and decimal numbers)
    public static double getValidAmount(Scanner scanner) {
        double amount = 0;
        while (amount <= 0 || amount>1000000) {
            try {
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.print("Amount must be positive. Please try again: ");
                }
                if(amount>1000000) {
                    System.out.print("Amount is greater than 1000000. Please try again: ");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume newline
        return amount;
    }

    // Method to validate the date (including checking for future dates)
    public static String getValidDate(Scanner scanner) {
        String date;
        while (true) {
            System.out.print("Enter Date (dd/MM/yyyy) : ");
            date = scanner.nextLine().trim();
            if (isValidDate(date)) {
                // Check if the date is not in the future
                LocalDate enteredDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate today = LocalDate.now();
                if (enteredDate.isAfter(today)) {
                    System.out.println("The date cannot be in the future. Please enter a valid date.");
                } else {
                    break; // Date is valid and not in the future, exit the loop
                }
            } else {
                System.out.println("Invalid date! Please enter the date in dd/MM/yyyy format.");
            }
        }
        return date;
    }

    // Helper method to check if the date is valid using LocalDate
    private static boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            // Try to parse the date string into a LocalDate object
            LocalDate parsedDate = LocalDate.parse(date, formatter);

            // Check if the parsed date matches the original input (ensures correct format)
            if (date.equals(parsedDate.format(formatter))) {
                return true;
            }
        } catch (DateTimeParseException e) {
            // If the date is invalid, an exception will be thrown
            return false;
        }
        return false;
    }    
}
