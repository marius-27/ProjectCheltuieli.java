package models;

import java.time.LocalDate;

public class Expense extends Transactions {
    private String category;

    // Constructor
    public Expense(String id, double amount, LocalDate date, String description, String category) {
        super(id, amount, date, description);
        this.category = category;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void displayTransactionDetails() {
        System.out.println("Expense Details:");
        System.out.println("ID: " + getId());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate());
        System.out.println("Description: " + getDescription());
        System.out.println("Category: " + category);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + getId() + '\'' +
                ", amount=" + getAmount() +
                ", date=" + getDate() +
                ", description='" + getDescription() + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}