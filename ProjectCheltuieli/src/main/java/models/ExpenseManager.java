package models;

import Imodels.IExpenseManager;
import persistence.DataPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseManager implements IExpenseManager {
    private List<Transactions> transactions;

    public ExpenseManager() {
        this.transactions = new ArrayList<>();
    }

    // Metoda pentru a adauga o tranzactie (cheltuiala sau venit)
    public void addTransaction(Transactions transaction) {
        transactions.add(transaction);
    }

    // Metoda pentru a obtine toate tranzacțiile
    public List<Transactions> getTransactions() {
        return new ArrayList<>(transactions);
    }

    // Metoda pentru a obtine toate cheltuielile
    public List<Expense> getExpenses() {
        return transactions.stream()
                .filter(transaction -> transaction instanceof Expense)
                .map(transaction -> (Expense) transaction)
                .collect(Collectors.toList());
    }

    // Metoda pentru a obtine toate veniturile
    public List<Income> getIncomes() {
        return transactions.stream()
                .filter(transaction -> transaction instanceof Income)
                .map(transaction -> (Income) transaction)
                .collect(Collectors.toList());
    }

    // Metoda pentru a calcula totalul cheltuielilor
    public double calculateTotalExpenses() {
        return transactions.stream()
                .filter(transaction -> transaction instanceof Expense)
                .mapToDouble(Transactions::getAmount)
                .sum();
    }

    // Metoda pentru a calcula totalul veniturilor
    public double calculateTotalIncomes() {
        return transactions.stream()
                .filter(transaction -> transaction instanceof Income)
                .mapToDouble(Transactions::getAmount)
                .sum();
    }

    // Salvarea datelor in fisiere JSON
    public void saveData(String expensesFile, String incomesFile) throws Exception {
        List<Expense> expenses = getExpenses();
        List<Income> incomes = getIncomes();

        DataPersistence.saveExpenses(expenses, expensesFile);
        DataPersistence.saveIncomes(incomes, incomesFile);
    }

    // Incarcarea datelor din fisiere JSON
    public void loadData(String expensesFile, String incomesFile) throws Exception {
        List<Expense> loadedExpenses = DataPersistence.loadExpenses(expensesFile);
        List<Income> loadedIncomes = DataPersistence.loadIncomes(incomesFile);

        transactions.clear();
        transactions.addAll(loadedExpenses);
        transactions.addAll(loadedIncomes);
    }
}
