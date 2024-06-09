package org.example.repository;

import org.example.model.Account;

import java.util.List;

public interface AccountRepository {
    void createAccount(Account account);

    void createAccounts(List<Account> accounts);

    List<Account> getAllAccounts();

    Account getAccountById(int accountId);

    boolean updateAccount(Account updatedAccount);

    boolean deleteAccount(int accountId);
}
