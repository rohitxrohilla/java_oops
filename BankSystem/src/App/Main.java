package App;

import Repository.AccountRepository;
import Repository.TransactionRepository;
import service.BankService;
import service.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        BankService bankService = new BankServiceImpl(accountRepository,transactionRepository);
        boolean running = true;
        while(running){
        System.out.println("Welcome to Bank");
        System.out.println();
        System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdraw
                4) Transfer
                5) Account Statement
                6) List Accounts
                7) Search Account by customer name
                0) Exit
                """);
        System.out.println();
        System.out.println("Please Enter you choice: ");
        String choice = sc.nextLine().trim();

        switch(choice){
            case "1" -> openAccount(sc,bankService);
            case "2" -> deposit(sc,bankService);
            case "3" -> withdraw(sc,bankService);
            case "4" -> transfer(sc,bankService);
            case "5" -> accountStatement(sc,bankService);
            case "6" -> listAccounts(bankService);
            case "0" -> running=false;
        }
        }


    }

    private static void openAccount(Scanner sc,BankService bankService) {
        System.out.println("Customer Name: ");
        String name = sc.nextLine().trim();
        System.out.println("Customer Email: ");
        String email = sc.nextLine().trim();
        System.out.println("Account Type (Savings/Current): ");
        String type = sc.nextLine().trim();
        System.out.println("Initial Deposit (optional): ");
        String amountStr = sc.nextLine();
        Double intialAmount = Double.parseDouble(amountStr);
        bankService.openAccount(name,email,type);
        System.out.println("!! Account Created !!");

    }

    private static void deposit(Scanner sc,BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = sc.nextLine().trim();
        System.out.println("Amount to be deposited: ");
        String deposited = sc.nextLine().trim();
        double amount = Double.parseDouble(deposited);
        bankService.deposit(accountNumber,amount);
        System.out.println("deposited !!");


    }

    private static void withdraw(Scanner sc,BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = sc.nextLine().trim();
        System.out.println("Amount to be withdrawn: ");
        String withdrawn = sc.nextLine().trim();
        double amount = Double.parseDouble(withdrawn);
        bankService.withdraw(accountNumber,amount);
        System.out.println("withdraw done");

    }

    private static void transfer(Scanner sc,BankService bankService) {
        System.out.println("Sender Account: ");
        String senderAcc = sc.nextLine().trim();
        System.out.println("Amount to transfer: ");
        String transfer = sc.nextLine().trim();
        double amount = Double.parseDouble(transfer);
        System.out.println("Receiver Account: ");
        String receiverAcc = sc.nextLine().trim();
        bankService.transfer(senderAcc,amount,receiverAcc);

    }

    private static void accountStatement(Scanner sc,BankService bankService) {
        System.out.println("Enter Account Number: ");
        String accountNumber = sc.nextLine().trim();
        bankService.accStatement(accountNumber).forEach(t->{
            System.out.println(t.getAccountNumber() + " | " + t.getTransferType() + " | " + t.getTransactionAmount() + " | " + t.getTransactionId() );
        });
    }

    private static void listAccounts(BankService bankService) {
        bankService.listAccounts().forEach(a->{
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + "  | " + a.getBalance());
        });
    }

    private static void searchAccount(Scanner sc,BankService bankService) {
        System.out.println("Enter customer name: ");
        String name = sc.nextLine().trim();


    }
}
