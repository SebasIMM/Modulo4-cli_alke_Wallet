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
    }

    public void createAccounts(List<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    // Read
    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Account getAccountById(int accountId) {
        return accounts.stream()
                .filter(acc -> acc.getId() == accountId)
                .findFirst()
                .orElse(null);
    }

    // Update
    public boolean updateAccount(Account updatedAccount) {
        Account account = getAccountById(updatedAccount.getId());
        if (account != null) {
            account.setName(updatedAccount.getName());
            account.setAge(updatedAccount.getAge());
            account.setPassWd(updatedAccount.getPassWd());
            account.setBalance(updatedAccount.getBalance());
            return true;
        } else {
            System.out.println("Cuenta con el id " + updatedAccount.getId() + " no encontrada");
            return false;
        }
    }

    // Delete
    public boolean deleteAccount(int accountId) {
        Account account = getAccountById(accountId);

        if (account != null) {
            accounts.remove(account);
            System.out.println("Cuenta eliminada: " + account);
            return true;
        } else {
            System.out.println("Cuenta no encontrada");
            return false;
        }
    }
}
