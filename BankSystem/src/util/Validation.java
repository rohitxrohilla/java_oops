package util;

import exceptions.AccountNotFound;
import exceptions.InvalidAmount;
import exceptions.InvalidInput;

public class Validation {
    public static void requirePositiveAmount(double amount){
        if(amount<=0){
            throw new InvalidAmount("Amount must be greater than 0");
        }
    }
    public static void requireNonBlank(String value,String fieldName){
        if(value==null||value.isBlank()){
            throw new InvalidInput(fieldName + " cannot be empty");
        }
    }
    public static void requireDifferentAccount(String from,String to){
        if(from.equals(to)){
            throw new AccountNotFound("Account cannot be same");
        }
    }
}
