# Personal Finance Manager

Personal Finance Manager that allows users to track income, expenses, and generate financial reports. Note: The system does not use a database and should store data in memory. (Terminal Based Application) 

## 1. Income Module

-   Objective: To manage and track sources of income for the user.

### Functional Requirements:

 Add Income:

- Input: Income Source (e.g., salary, freelance work), Amount, Date.  
- Validation:  
	- Ensure the income source is not empty.  
	- Ensure the amount is a positive numeric value.  
	- Ensure the date is valid.  
- Output: Confirmation message that the income has been added successfully.

View Income:

- Output: Display a list of all income sources with details such as source, amount, and date.

Update Income:

- Input: Income ID or Source.  
- Validation: Ensure that the source or ID corresponds to an existing income record.  
- Output: Update income details and provide a confirmation message.

Delete Income:

- Input: Income ID or Source.  
- Output: Remove the selected income record and provide a confirmation message.

## 2. Expenses Module

-   Objective: To manage and track all types of user expenses.

### Functional Requirements:

Add Expense:

- Input: Expense Category (e.g., food, rent, entertainment), Amount, Date.  
- Validation:  
	- Ensure the expense category is not empty.  
	- Ensure the amount is a positive numeric value.  
	- Ensure the date is valid.  
- Output: Confirmation message that the expense has been added successfully.

View Expenses:

- Output: Display a list of all expenses with details such as category, amount, and date.

Update Expense:

- Input: Expense ID or Category.  
- Validation: Ensure that the expense corresponds to an existing record.  
- Output: Update expense details and provide a confirmation message.

Delete Expense:

- Input: Expense ID or Category.  
- Output: Remove the selected expense record and provide a confirmation message.

## 3. Financial Report Module

-   Objective: To generate financial reports showing income, expenses, and balance over a specified period.

### Functional Requirements:

Generate Report:

- Input: Start Date and End Date for the report period.  
- Output: Display the total income, total expenses, and balance for the specified period.

View Summary Report:

- Output: Display a summary report showing total income, total expenses, and remaining balance.

View Detailed Report:

- Output: Display a detailed breakdown of all income and expense transactions for the specified period.

## 4. User Interface Module

-   Objective: To provide a simple, console-based interface for users to interact with the system.

### Functional Requirements:

Main Menu:

- Options to navigate:  
	- Add Income  
	- View Income  
	- Add Expense  
	- View Expenses  
	- Generate Financial Report  
	- Exit  
- Input Handling: Prompt the user to select an option and navigate accordingly.

Input Handling:

- Provide clear prompts for each required input.  
- Implement error handling for invalid input (e.g., incorrect data type, empty fields).  
- Return to the main menu after each action.

## 5. Exception Handling Module

-   Objective: To ensure that any errors are managed gracefully with appropriate messages.

### Functional Requirements:

Validation of Inputs:

- Ensure that numeric inputs (income amount, expense amount) are positive values.  
- Ensure that date inputs are in a valid format (e.g., MM/DD/YYYY).

Error Handling:

- Catch input errors such as invalid data types (e.g., text instead of numbers).  
- Provide clear and user-friendly error messages when inputs are invalid.