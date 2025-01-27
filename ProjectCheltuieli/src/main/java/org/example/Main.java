package org.example;

import models.Expense;
import models.Income;
import models.ExpenseManager;
import java.time.LocalDate;
import java.util.Scanner;
import models.ProfitLossCalculator;
import enums.FinancialResult;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("======================");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View Transactions");
            System.out.println("4. View Total Expenses");
            System.out.println("5. View Total Incomes");
            System.out.println("6. Save Data");
            System.out.println("7. Load Data");
            System.out.println("8. Calculate Profit or Loss");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense ID: ");
                    String expenseId = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    LocalDate expenseDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Description: ");
                    String expenseDescription = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    Expense expense = new Expense(expenseId, expenseAmount, expenseDate, expenseDescription, category);
                    manager.addTransaction(expense);
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Income ID: ");
                    String incomeId = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    LocalDate incomeDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Description: ");
                    String incomeDescription = scanner.nextLine();
                    System.out.print("Enter Source: ");
                    String source = scanner.nextLine();

                    Income income = new Income(incomeId, incomeAmount, incomeDate, incomeDescription, source);
                    manager.addTransaction(income);
                    System.out.println("Income added successfully!");
                    break;

                case 3:
                    System.out.println("All Transactions:");
                    manager.getTransactions().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Total Expenses: " + manager.calculateTotalExpenses());
                    break;

                case 5:
                    System.out.println("Total Incomes: " + manager.calculateTotalIncomes());
                    break;

                case 6:
                    try {
                        manager.saveData("expenses.json", "incomes.json");
                        System.out.println("Data saved successfully!");
                    } catch (Exception e) {
                        System.out.println("Error saving data: " + e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        manager.loadData("expenses.json", "incomes.json");
                        System.out.println("Data loaded successfully!");
                    } catch (Exception e) {
                        System.out.println("Error loading data: " + e.getMessage());
                    }
                    break;

                case 8:
                    ProfitLossCalculator calculator = new ProfitLossCalculator(manager.getIncomes(), manager.getExpenses());
                    FinancialResult result = calculator.calculateResult();
                    System.out.println("======================");
                    System.out.println("Financial Result: " + result);
                    System.out.println("Total Income: " + calculator.getTotalIncome());
                    System.out.println("Total Expense: " + calculator.getTotalExpense());
                    System.out.println("Net Amount: " + calculator.getNetAmount());
                    System.out.println("======================");
                    break;

                case 9:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}