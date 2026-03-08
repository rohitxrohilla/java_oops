package domain;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double transactionAmount;
    private LocalDateTime time;
    private Type transferType;

    public Transaction( String transactionId, String accountNumber, double transactionAmount, LocalDateTime time, Type transferType) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
        this.time = time;
        this.transferType = transferType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public Type getTransferType() {
        return transferType;
    }
}
