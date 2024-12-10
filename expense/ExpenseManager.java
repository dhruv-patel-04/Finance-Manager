package expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenseList = new ArrayList<>();

    public void addExpense(String category, double amount, String date) {
        try {
            if (category == null || category.isEmpty()) {
                throw new IllegalArgumentException("Expense category cannot be empty.");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Expense amount must be a positive value.");
            }
            if (date == null || date.isEmpty()) {
                throw new IllegalArgumentException("Date cannot be empty.");
            }
            expenseList.add(new Expense(category, amount, date));
            System.out.println("Expense added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expense records available.");
            return;
        }
        System.out.println("\nExpense Records:");
        for (Expense expense : expenseList) {
            System.out.println(expense);
        }
    }

    public void updateExpense(String category, double newAmount, String Date) {
        Expense expenseToUpdate = null;

        // Find the expense by source
        for (Expense expense : expenseList) {
            if (expense.getCategory().equalsIgnoreCase(category) && expense.getDate().equalsIgnoreCase(Date)) {
                expenseToUpdate = expense;
                break;
            }
        }

        // If no matching income is found
        if (expenseToUpdate == null) {
            System.out.println("Expense with the given category not found.");
            return;
        }

        // Update the income details
        expenseToUpdate.setAmount(newAmount);
        System.out.println("Expense updated successfully!");
    }

    public void deleteExpense(String category, String DatetoDeleteExp) {
        Expense expenseToDelete = null;

        // Find the income by source
        for (Expense expense : expenseList) {
            if (expense.getCategory().equalsIgnoreCase(category) && expense.getDate().equalsIgnoreCase(DatetoDeleteExp)) {
                expenseToDelete = expense;
                break;
            }
        }

        // If no matching income is found
        if (expenseToDelete == null) {
            System.out.println("Expense with the given category not found.");
            return;
        }

        // Remove the income record
        expenseList.remove(expenseToDelete);
        System.out.println("Expense deleted successfully!");
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }
}
