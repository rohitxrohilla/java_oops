package domain;

import exceptions.InsufficientBalance;
import exceptions.InvalidAmount;

public class Account {
    private String accountNumber;
    private String customerId;
    private double balance = 0.0;
    private String accountType;

    public Account(String accountNumber, String customerId, String accountType) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
    }

    public void Deposit(double amount){
        if(amount<=0){
            throw new InvalidAmount("Amount must be positive");
        }
        balance+=amount;
    }
    public void withdraw(double amount){
        if(amount<=0){
            throw new InvalidAmount("Amount must be positive");
        }
        if (amount>balance){
            throw new InsufficientBalance("Not enough balance");
        }
        balance-=amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

}
