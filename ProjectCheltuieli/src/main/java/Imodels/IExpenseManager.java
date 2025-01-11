package Imodels;

import models.Expense;
import models.Income;
import models.Transactions;

import java.util.List;

public interface IExpenseManager {
    // Adăugare tranzacție (cheltuială sau venit)
    void addTransaction(Transactions transaction);

    // Obținere toate tranzacțiile
    List<Transactions> getTransactions();

    // Obținere toate cheltuielile
    List<Expense> getExpenses();

    // Obținere toate veniturile
    List<Income> getIncomes();

    // Calcul total cheltuieli
    double calculateTotalExpenses();

    // Calcul total venituri
    double calculateTotalIncomes();

    // Salvare date
    void saveData(String expensesFile, String incomesFile) throws Exception;

    // Încărcare date
    void loadData(String expensesFile, String incomesFile) throws Exception;
}
