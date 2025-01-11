package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseManagerTest {

    private ExpenseManager manager;

    @BeforeEach
    void setUp() {
        manager = new ExpenseManager();
        manager.addTransaction(new Expense("1", 100.0, LocalDate.now(), "Prânz la restaurant", "Mâncare"));
        manager.addTransaction(new Expense("2", 200.0, LocalDate.now(), "Chirie", "Locuință"));
        manager.addTransaction(new Income("3", 1500.0, LocalDate.now(), "Salariu", "Job"));
    }

    @Test
    void addTransaction() {
        int beforeSize = manager.getTransactions().size();
        manager.addTransaction(new Expense("4", 50.0, LocalDate.now(), "Snacks", "Mâncare"));
        int afterSize = manager.getTransactions().size();
        assertEquals(beforeSize + 1, afterSize, "O tranzacție ar trebui adăugată cu succes");
    }

    @Test
    void getTransactions() {
        List<Transactions> tranzactii = manager.getTransactions();
        assertEquals(3, tranzactii.size(), "Managerul ar trebui să conțină 3 tranzacții inițiale");
    }

    @Test
    void getExpenses() {
        List<Expense> cheltuieli = manager.getExpenses();
        assertEquals(2, cheltuieli.size(), "Ar trebui să existe 2 cheltuieli");
    }

    @Test
    void getIncomes() {
        List<Income> venituri = manager.getIncomes();
        assertEquals(1, venituri.size(), "Ar trebui să existe 1 venit");
    }

    @Test
    void calculateTotalExpenses() {
        double totalCheltuieli = manager.calculateTotalExpenses();
        assertEquals(300.0, totalCheltuieli, "Totalul cheltuielilor ar trebui să fie 300.0");
    }

    @Test
    void calculateTotalIncomes() {
        double totalVenituri = manager.calculateTotalIncomes();
        assertEquals(1500.0, totalVenituri, "Totalul veniturilor ar trebui să fie 1500.0");
    }

    @Test
    void saveData() {
        assertDoesNotThrow(() -> manager.saveData("test_expenses.json", "test_incomes.json"),
                "Datele ar trebui salvate fără a genera excepții");
    }

    @Test
    void loadData() {
        assertDoesNotThrow(() -> {
            manager.saveData("test_expenses.json", "test_incomes.json");
            manager.loadData("test_expenses.json", "test_incomes.json");
        }, "Datele ar trebui încărcate fără a genera excepții");
    }
}
