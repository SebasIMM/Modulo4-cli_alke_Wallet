package org.example;

import org.example.repository.AccountRepository;
import org.example.util.CsvUtil;

public class Main {
    public static void main(String[] args) {
        AccountRepository accountRep = new AccountRepository();
        CsvUtil.writeAccountsToCsv(accountRep.getAllAccounts());

        accountRep.createAccount(1, "Sebas", 24);
        accountRep.createAccount(2, "Marcelo", 32);
        accountRep.createAccount(3, "Tamara", 29);

        System.out.println(accountRep.updateAccount(2,"Sebita",18));
        System.out.println(accountRep.getAllAccounts());
        System.out.println(accountRep.deleteAccount(2));
        System.out.println(accountRep.getAllAccounts());


    }
}