package Imodels;

import java.time.LocalDate;

public interface ITransactions {
    String getId();
    void setId(String id);

    double getAmount();
    void setAmount(double amount);

    LocalDate getDate();
    void setDate(LocalDate date);

    String getDescription();
    void setDescription(String description);

    void displayTransactionDetails();
}
