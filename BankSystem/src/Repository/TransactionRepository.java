package Repository;

import domain.Transaction;

import java.util.*;

public class TransactionRepository {
    private final Map<String, List<Transaction>> transactions = new HashMap<>();

    public void save(Transaction transaction){
        transactions.computeIfAbsent(transaction.getAccountNumber(), k-> new ArrayList<>()).add(transaction);
    }
    public List<Transaction> findByAccNum(String accNum){

        return transactions.getOrDefault(accNum, Collections.emptyList());
    }




}
