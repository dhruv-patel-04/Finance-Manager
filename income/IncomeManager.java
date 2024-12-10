package income;

import java.util.ArrayList;
import java.util.List;

public class IncomeManager {
    private List<Income> incomeList = new ArrayList<>();

    public void addIncome(String source, double amount, String date) {
        try {
            if (source == null || source.isEmpty()) {
                throw new IllegalArgumentException("Income source cannot be empty.");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Income amount must be a positive value.");
            }
            if (date == null || date.isEmpty()) {
                throw new IllegalArgumentException("Date cannot be empty.");
            }
            incomeList.add(new Income(source, amount, date));
            System.out.println("Income added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewIncome() {
        if (incomeList.isEmpty()) {
            System.out.println("No income records available.");
            return;
        }
        System.out.println("\nIncome Records:");
        for (Income income : incomeList) {
            System.out.println(income);
        }
    }

    public void updateIncome(String source, double newAmount, String Date) {
        Income incomeToUpdate = null;

        // Find the income by source
        for (Income income : incomeList) {
            if (income.getSource().equalsIgnoreCase(source) && income.getDate().equalsIgnoreCase(Date)) {
                incomeToUpdate = income;
                break;
            }
        }

        // If no matching income is found
        if (incomeToUpdate == null) {
            System.out.println("Income with the given source not found.");
            return;
        }

        // Update the income details
        incomeToUpdate.setAmount(newAmount);
        System.out.println("Income updated successfully!");
    }

    public void deleteIncome(String source, String DatetoDelete) {
        Income incomeToDelete = null;

        // Find the income by source
        for (Income income : incomeList) {
            if (income.getSource().equalsIgnoreCase(source) && income.getDate().equalsIgnoreCase(DatetoDelete)) {
                incomeToDelete = income;
                break;
            }
        }

        // If no matching income is found
        if (incomeToDelete == null) {
            System.out.println("Income with the given source not found.");
            return;
        }

        // Remove the income record
        incomeList.remove(incomeToDelete);
        System.out.println("Income deleted successfully!");
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }
}
