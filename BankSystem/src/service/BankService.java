package service;

import domain.Account;
import domain.Transaction;

import java.util.List;

public interface BankService {
    String openAccount(String name, String email, String accountType);
    List<Account> listAccounts();
    void deposit(String accountNumber,double amount);
    void withdraw(String accountNumber,double amount);

    void transfer(String senderAcc,double amount,String receiverAcc);

    List<Transaction> accStatement(String accountNumber);
}