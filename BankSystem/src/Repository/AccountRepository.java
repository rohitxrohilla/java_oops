package Repository;

import domain.Account;

import java.util.*;

public class AccountRepository {
    private final Map<String, Account> accounts= new HashMap<>();

    public void save(Account account){
        accounts.put(account.getAccountNumber(), account);
    }
    public List<Account> listAll(){
        return new ArrayList<>(accounts.values());
    }
    public Optional<Account> findByAccountNumber(String accountNumber){
        return Optional.ofNullable(accounts.get(accountNumber));
    }

}
