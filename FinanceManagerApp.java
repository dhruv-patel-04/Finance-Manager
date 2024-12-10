import income.IncomeManager;
import expense.ExpenseManager;
import report.ReportGenerator;
import exception.ExceptionHandler;  // Import the ExceptionHandler class

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinanceManagerApp {
    public static void main(String[] args) {
        IncomeManager incomeManager = new IncomeManager();
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n=== Personal Finance Manager ===");
                System.out.println("1. Add Income");
                System.out.println("2. View Income");
                System.out.println("3. Edit Income");
                System.out.println("4. Delete Income");
                System.out.println("5. Add Expense");
                System.out.println("6. View Expenses");
                System.out.println("7. Edit Expense");
                System.out.println("8. Delete Expense");
                System.out.println("9. Generate Financial Report");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        String source;
                        while (true) {
                            System.out.print("Enter Income Source [Press 1 for Salary or 2 for Freelance Work] : ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                source = "Salary";
                                break;
                            }   
                            else if (choice == 2) {
                                source = "Freelance Work";
                                break;
                            }
                            else {
                                System.out.println("Enter Valid Input.");
                            }
                        }
                    
                        System.out.print("Enter Income Amount: ");
                        // Validate the amount
                        double amount = ExceptionHandler.getValidAmount(scanner);
                        // Validate the date
                        String date = ExceptionHandler.getValidDate(scanner);
                        incomeManager.addIncome(source, amount, date);
                        break;

                    case 2:
                        incomeManager.viewIncome();
                        break;

                    case 3:
                        String incomeSourceToUpdate ;
                        while (true) {
                            System.out.print("Enter Income Source to update [Press 1 for Salary or 2 for Freelance Work] : ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                incomeSourceToUpdate = "Salary";
                                break;
                            }   
                            else if (choice == 2) {
                                incomeSourceToUpdate = "Freelance Work";
                                break;
                            }
                            else {
                                System.out.println("Enter Valid Input.");
                            }
                        }
                        System.out.print("Enter New Income Amount: ");
                        double newAmount = ExceptionHandler.getValidAmount(scanner);  // Use ExceptionHandler for input validation
                        String Date = ExceptionHandler.getValidDate(scanner);  // Validate date
                        incomeManager.updateIncome(incomeSourceToUpdate, newAmount, Date);
                    break;

                    case 4:
                        String incomeSourceToDelete;
                        while (true) {
                            System.out.print("Enter Income Source to Delete [Press 1 for Salary or 2 for Freelance Work] : ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                incomeSourceToDelete = "Salary";
                                break;
                            }   
                            else if (choice == 2) {
                                incomeSourceToDelete = "Freelance Work";
                                break;
                            }
                            else {
                                System.out.println("Enter Valid Input.");
                            }
                        }
                        String DatetoDelete = ExceptionHandler.getValidDate(scanner);
                        incomeManager.deleteIncome(incomeSourceToDelete, DatetoDelete);
                        break;

                    case 5:
                        String category;
                        while (true) {
                            System.out.print("Enter Expense Category [Press 1 for Food or 2 for Rent 3 for Entertainment] : ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                category = "Food";
                                break;
                            }   
                            else if (choice == 2) {
                                category = "Rent";
                                break;
                            }
                            else if (choice == 3) {
                                category = "Entertainment";
                                break;
                            }
                            else {
                                System.out.println("Enter Valid Input.");
                            }
                        }

                        System.out.print("Enter Expense Amount: ");
                        // Validate the amount
                        double expenseAmount = ExceptionHandler.getValidAmount(scanner);
                        // Validate the date
                        String expenseDate = ExceptionHandler.getValidDate(scanner);
                        expenseManager.addExpense(category, expenseAmount, expenseDate);
                        break;

                    case 6:
                        expenseManager.viewExpenses();
                        break;

                    case 7:
                        String expenseCategoryToUpdate;

                        while (true) {
                            System.out.print("Enter Expense Category to update [Press 1 for Food or 2 for Rent 3 for Entertainment] : ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                expenseCategoryToUpdate = "Food";
                                break;
                            }   
                            else if (choice == 2) {
                                expenseCategoryToUpdate = "Rent";
                                break;
                            }
                            else if (choice == 3) {
                                expenseCategoryToUpdate = "Entertainment";
                            }
                            else {
                                System.out.println("Enter Valid Input.");
                            }
                        }

                        System.out.print("Enter New Expense Amount: ");
                        double newExpAmount = ExceptionHandler.getValidAmount(scanner);  // Use ExceptionHandler for input validation
                        String ExpDate = ExceptionHandler.getValidDate(scanner);  // Validate date
                        expenseManager.updateExpense(expenseCategoryToUpdate, newExpAmount, ExpDate);
                    break;

                    case 8:
                        String expenseCategoryToDelete;
                        while (true) {
                            System.out.print("Enter Expense Category to Delete [Press 1 for Food or 2 for Rent 3 for Entertainment] : ");
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                expenseCategoryToDelete = "Food";
                                break;
                            }   
                            else if (choice == 2) {
                                expenseCategoryToDelete = "Rent";
                                break;
                            }
                            else if (choice == 3) {
                                expenseCategoryToDelete = "Entertainment";
                            }
                            else {
                                System.out.println("Enter Valid Input.");
                            }
                        }
                        String DatetoDeleteExp = ExceptionHandler.getValidDate(scanner);

                        expenseManager.deleteExpense(expenseCategoryToDelete,DatetoDeleteExp);
                        break;
                    
                    case 9:
                        System.out.print("Starts from - ");
                        String startDate = ExceptionHandler.getValidDate(scanner); // Validate the start date
                        System.out.print("Ends on - ");
                        String endDate = ExceptionHandler.getValidDate(scanner); // Validate the end date
                        ReportGenerator.generateReport(
                                incomeManager.getIncomeList(),
                                expenseManager.getExpenseList(),
                                startDate,
                                endDate
                        );

                        while (true) {
                            System.out.print("\nEnter 1 : To View Detailed Report.\n");
                            System.out.println("Enter 0 : Go To Main Menu.");
                            int choice = scanner.nextInt();
                            if(choice == 1) {
                                ReportGenerator.generateDetailedReport(
                                incomeManager.getIncomeList(),
                                expenseManager.getExpenseList(),
                                startDate,
                                endDate
                                );  
                            }
                            else if(choice == 0) {
                                break;
                            }
                            else {
                                System.out.println("Invalid Choice. Please Enter 0 or 1.");
                            } 
                        }
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter the correct data type.");
                scanner.nextLine(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}