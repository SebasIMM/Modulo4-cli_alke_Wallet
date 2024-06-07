package org.example.repository;

import org.example.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    // Create
    public void createAccount(String id, String name, String age, String passWd) {
        Account account = new Account(id, name, age, passWd);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    public void createAccounts(List<Account> accountsFromCsv) {
        for (Account account : accountsFromCsv) {
            createAccount(account.getId(), account.getName(), account.getAge(), account.getPassWd());
        }
    }

    // Read
    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Optional<Account> getAccountById(String id) {
        return accounts.stream().filter(acc -> acc.getId().equals(id)).findFirst();
    }

    // Update
    public boolean updateAccount(String id, String name, String age) {
        Optional<Account> optionalAccount = getAccountById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setName(name);
            account.setAge(age);
            System.out.println("Account updated: " + account);
            return true;
        } else {
            System.out.println("Account with id " + id + " not found.");
            return false;
        }
    }

    // Delete
    public boolean deleteAccount(String id) {
        Optional<Account> optionalAccount = getAccountById(id);

        if (optionalAccount.isPresent()) {
            accounts.remove(optionalAccount.get());
            System.out.println("Account deleted: " + optionalAccount.get());
            return true;
        } else {
            System.out.println("Account with id " + id + " not found.");
            return false;
        }
    }

}
