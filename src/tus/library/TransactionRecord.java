package tus.library;

import java.time.LocalDate;

// Record Class
public class TransactionRecord {
    int userId;
    float amountPaid;
    LocalDate transactionDate;

    public TransactionRecord(int userId, float amountPaid, LocalDate transactionDate) {
        this.userId = userId;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
    }

    public int getUserId() {
        return userId;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
