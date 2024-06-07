package org.example.repository;

import org.example.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    // Create
    public void createAccount(int id, String name, int age) {
        Account account = new Account(id, name, age);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    // Read
    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Optional<Account> getAccountById(int id) {
        return accounts.stream().filter(acc -> acc.getId() == id).findFirst();
    }

    // Update
    public boolean updateAccount(int id, String name, int age) {
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
    public boolean deleteAccount(int id) {
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
