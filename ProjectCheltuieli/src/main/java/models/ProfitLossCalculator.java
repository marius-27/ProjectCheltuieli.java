package models;

import enums.FinancialResult;
import java.util.List;

/**
 * Class to calculate whether there is a profit or a loss based on income and expenses.
 */
public class ProfitLossCalculator {

    private double totalIncome;
    private double totalExpense;

    /**
     * Constructor that calculates total income and expenses based on the provided lists.
     *
     * @param incomes List of incomes
     * @param expenses List of expenses
     */
    public ProfitLossCalculator(List<Income> incomes, List<Expense> expenses) {
        this.totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        this.totalExpense = expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    /**
     * Calculates whether the result is profit or loss.
     *
     * @return FinancialResult indicating PROFIT or LOSS
     */
    public FinancialResult calculateResult() {
        return totalIncome > totalExpense ? FinancialResult.PROFIT : FinancialResult.LOSS;
    }

    /**
     * Gets the total income.
     *
     * @return Total income
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * Gets the total expenses.
     *
     * @return Total expenses
     */
    public double getTotalExpense() {
        return totalExpense;
    }

    /**
     * Calculates the net amount (income - expenses).
     *
     * @return Net amount
     */
    public double getNetAmount() {
        return totalIncome - totalExpense;
    }
}
