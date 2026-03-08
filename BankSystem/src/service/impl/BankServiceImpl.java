package service.impl;

import Repository.AccountRepository;
import Repository.TransactionRepository;
import domain.Account;
import domain.Transaction;
import domain.Type;
import exceptions.AccountNotFound;
import service.BankService;
import util.Validation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BankServiceImpl implements BankService {

    private int counter = 1000;
    private String generateAccountNumber(){
        counter++;
        return "AC" + counter;
    }

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public BankServiceImpl(AccountRepository accountRepository,TransactionRepository transactionRepository){
        this.accountRepository=accountRepository;
        this.transactionRepository=transactionRepository;
    }

    @Override
    public String openAccount(String name, String email, String accountType) {

        Validation.requireNonBlank(name, "Customer name");
        Validation.requireNonBlank(email, "Email");
        Validation.requireNonBlank(accountType, "Account Type");


        String customerId = UUID.randomUUID().toString();
        String accountNumber = generateAccountNumber();
        Account account = new Account(accountNumber,customerId,accountType);

        // save the account
        accountRepository.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.listAll();
    }

    @Override
    public void deposit(String accountNumber, double amount) {

        Validation.requireNonBlank(accountNumber,"Account Number");
        Validation.requirePositiveAmount(amount);

        Account account = accountRepository.findByAccountNumber(accountNumber).
                orElseThrow(()->new AccountNotFound("Account not found"));

        Transaction transaction = new Transaction(UUID.randomUUID().toString(),account.getAccountNumber(),amount, LocalDateTime.now(), Type.Deposit);

        account.Deposit(amount);
        transactionRepository.save(transaction);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {

        Validation.requireNonBlank(accountNumber, "Account Number");
        Validation.requirePositiveAmount(amount);

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()->new AccountNotFound("Account not found"));
        account.withdraw(amount);

        Transaction transaction = new Transaction(UUID.randomUUID().toString(),account.getAccountNumber(),amount,LocalDateTime.now(),Type.Withdraw);
        transactionRepository.save(transaction);
    }

    @Override
    public void transfer(String fromAccount, double amount, String toAccount) {

        Validation.requireNonBlank(fromAccount,"Senders Account");
        Validation.requireNonBlank(toAccount,"Receivers Account");
        Validation.requireDifferentAccount(fromAccount,toAccount);
        Validation.requirePositiveAmount(amount);

        if(fromAccount.equals(toAccount)){
            throw new RuntimeException("Both account are same");
        }
        Account sender = accountRepository.findByAccountNumber(fromAccount)
                .orElseThrow(()-> new AccountNotFound("Account number is wrong"));
        Account receiver = accountRepository.findByAccountNumber(toAccount)
                .orElseThrow(()-> new AccountNotFound("Account number is wrong"));

        sender.withdraw(amount);
        receiver.Deposit(amount);

        Transaction transaction1 = new Transaction(UUID.randomUUID().toString(),sender.getAccountNumber(),amount,LocalDateTime.now(),Type.TransferOUT);
        Transaction transaction2 = new Transaction(UUID.randomUUID().toString(),receiver.getAccountNumber(),amount,LocalDateTime.now(),Type.TransferIN);

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);

    }

    @Override
    public List<Transaction> accStatement(String accountNumber) {

        Validation.requireNonBlank(accountNumber,"Account Number");

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new AccountNotFound("Account not found"));

        return transactionRepository.findByAccNum(accountNumber);
    }


}
