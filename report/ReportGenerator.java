package report;

import income.Income;
import expense.Expense;

import java.util.List;

public class ReportGenerator {
    public static void generateReport(List<Income> incomeList, List<Expense> expenseList, String startDate, String endDate) {
        try {
            if (incomeList == null || expenseList == null) {
                throw new IllegalArgumentException("Income or expense data cannot be null.");
            }

            double totalIncome = 0;
            double totalExpenses = 0;

            for (Income income : incomeList) {
                totalIncome += income.getAmount();
            }

            for (Expense expense : expenseList) {
                totalExpenses += expense.getAmount();
            }

            double balance = totalIncome - totalExpenses;

            System.out.println("\nFinancial Report from " + startDate + " to " + endDate);
            System.out.println("Total Income: " + totalIncome);
            System.out.println("Total Expenses: " + totalExpenses);
            System.out.println("Balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while generating the report: " + e.getMessage());
        }
    }

    public static void generateDetailedReport(List<Income> incomeList, List<Expense> expenseList, String startDate, String endDate) {
        try {
            if (incomeList == null || expenseList == null) {
                throw new IllegalArgumentException("Income or expense data cannot be null.");
            }

            //double totalIncome = 0;
            //double totalExpenses = 0;
            System.out.println("- - - Income List - - -");
            for (Income income : incomeList) {
                System.out.println(income.toString());
            }

            System.out.println("- - - Expense List - - -");
            for (Expense expense : expenseList) {
                System.out.println(expense.toString());
            }

            //double balance = totalIncome - totalExpenses;

            // System.out.println("\nFinancial Report from " + startDate + " to " + endDate);
            // System.out.println("Total Income: " + totalIncome);
            // System.out.println("Total Expenses: " + totalExpenses);
            // System.out.println("Balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while generating the report: " + e.getMessage());
        }
    }
}
