package models;

import java.time.LocalDate;

public class Income extends Transactions {
    private String source;

    // Constructor
    public Income(String id, double amount, LocalDate date, String description, String source) {
        super(id, amount, date, description);
        this.source = source;
    }

    // Getter and Setter for source
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void displayTransactionDetails() {
        System.out.println("Income Details:");
        System.out.println("ID: " + getId());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate());
        System.out.println("Description: " + getDescription());
        System.out.println("Source: " + source);
    }

    @Override
    public String toString() {
        return "Income{" +
                "id='" + getId() + '\'' +
                ", amount=" + getAmount() +
                ", date=" + getDate() +
                ", description='" + getDescription() + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
