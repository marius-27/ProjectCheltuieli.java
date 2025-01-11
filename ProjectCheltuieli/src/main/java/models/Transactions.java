package models;

import Imodels.ITransactions;

import java.time.LocalDate;

public abstract class Transactions implements ITransactions {
    private String id;
    private double amount;
    private LocalDate date;
    private String description;

    // Constructor
    public Transactions(String id, double amount, LocalDate date, String description) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayTransactionDetails();

    @Override
    public String toString() {
        return "Transactions{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

}