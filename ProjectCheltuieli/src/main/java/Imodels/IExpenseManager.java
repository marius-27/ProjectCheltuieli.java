package Imodels;

import models.Expense;
import models.Income;
import models.Transactions;

import java.util.List;

public interface IExpenseManager {
    // Adaugare tranzactie (cheltuiala sau venit)
    void addTransaction(Transactions transaction);

    // Obtinere toate tranzactiile
    List<Transactions> getTransactions();

    // Obtinere toate cheltuielile
    List<Expense> getExpenses();

    // Obtinere toate veniturile
    List<Income> getIncomes();

    // Calcul total cheltuieli
    double calculateTotalExpenses();

    // Calcul total venituri
    double calculateTotalIncomes();

    // Salvare date
    void saveData(String expensesFile, String incomesFile) throws Exception;

    // Incarcare date
    void loadData(String expensesFile, String incomesFile) throws Exception;
}
