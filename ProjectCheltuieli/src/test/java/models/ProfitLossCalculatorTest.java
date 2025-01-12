package models;

import enums.FinancialResult;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfitLossCalculatorTest {

    @Test
    void calculateResult() {
        // Configurare
        Income income1 = new Income("1", 1000.0, LocalDate.now(), "Salariu", "Muncă");
        Income income2 = new Income("2", 500.0, LocalDate.now(), "Bonus", "Muncă");
        Expense expense1 = new Expense("1", 800.0, LocalDate.now(), "Chirie", "Locuință");
        Expense expense2 = new Expense("2", 200.0, LocalDate.now(), "Alimente", "Necesar");

        ProfitLossCalculator calculator = new ProfitLossCalculator(
                List.of(income1, income2),
                List.of(expense1, expense2)
        );

        // Testare
        assertEquals(FinancialResult.PROFIT, calculator.calculateResult(), "Rezultatul ar trebui să fie PROFIT");

        // Test pierdere
        Expense expense3 = new Expense("3", 800.0, LocalDate.now(), "Reparații", "Auto");
        ProfitLossCalculator calculatorWithLoss = new ProfitLossCalculator(
                List.of(income1),
                List.of(expense1, expense2, expense3)
        );
        assertEquals(FinancialResult.LOSS, calculatorWithLoss.calculateResult(), "Rezultatul ar trebui să fie LOSS");
    }

    @Test
    void getTotalIncome() {
        // Configurare
        Income income1 = new Income("1", 1200.0, LocalDate.now(), "Salariu", "Muncă");
        Income income2 = new Income("2", 800.0, LocalDate.now(), "Venit suplimentar", "Investiții");

        ProfitLossCalculator calculator = new ProfitLossCalculator(
                List.of(income1, income2),
                List.of()
        );

        // Testare
        assertEquals(2000.0, calculator.getTotalIncome(), 0.01, "Totalul veniturilor ar trebui să fie 2000.0");
    }

    @Test
    void getTotalExpense() {
        // Configurare
        Expense expense1 = new Expense("1", 500.0, LocalDate.now(), "Facturi", "Utilități");
        Expense expense2 = new Expense("2", 300.0, LocalDate.now(), "Transport", "Necesar");

        ProfitLossCalculator calculator = new ProfitLossCalculator(
                List.of(),
                List.of(expense1, expense2)
        );

        // Testare
        assertEquals(800.0, calculator.getTotalExpense(), 0.01, "Totalul cheltuielilor ar trebui să fie 800.0");
    }

    @Test
    void getNetAmount() {
        // Configurare
        Income income1 = new Income("1", 1500.0, LocalDate.now(), "Salariu", "Muncă");
        Expense expense1 = new Expense("1", 600.0, LocalDate.now(), "Chirie", "Locuință");

        ProfitLossCalculator calculator = new ProfitLossCalculator(
                List.of(income1),
                List.of(expense1)
        );

        // Testare
        assertEquals(900.0, calculator.getNetAmount(), 0.01, "Netul ar trebui să fie 900.0");
    }
}
