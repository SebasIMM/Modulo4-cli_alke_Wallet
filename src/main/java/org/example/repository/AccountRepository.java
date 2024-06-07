package org.example.repository;

import org.example.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private List<Account> accounts = new ArrayList<>();

    // Create
    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    public void createAccounts(List<Account> accounts) {
        for (Account account : accounts) {
            createAccount(account);
        }
    }

    // Read
    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Optional<Account> getAccountById(int accountId) {
        return accounts.stream().filter(acc -> acc.getId() == accountId).findFirst();
    }

    // Update
    public boolean updateAccount(Account updatedAccount) {
        Optional<Account> optionalAccount = getAccountById(updatedAccount.getId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setName(updatedAccount.getName());
            account.setAge(updatedAccount.getAge());
            account.setPassWd(updatedAccount.getPassWd());
            account.setBalance(updatedAccount.getBalance());
            System.out.println("Account updated: " + account);
            return true;
        } else {
            System.out.println("Account with id " + updatedAccount.getId() + " not found.");
            return false;
        }
    }

    // Delete
    public boolean deleteAccount(int accountId) {
        Optional<Account> optionalAccount = getAccountById(accountId);

        if (optionalAccount.isPresent()) {
            accounts.remove(optionalAccount.get());
            System.out.println("Account deleted: " + optionalAccount.get());
            return true;
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }
}
