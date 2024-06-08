package org.example.repository;

import org.example.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AccountRepositoryTest {
    private AccountRepository accountRepository;
    private List<Account> accounts;

    @Before
    public void setUp() {
        accountRepository = new AccountRepository();
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "Juan", 30, "1234", 100.0));
        accounts.add(new Account(2, "Claudia", 25, "1234", 200.0));
        accountRepository.createAccounts(accounts);
    }

    @Test
    public void testCreateAccount() {
        Account newAccount = new Account(3, "Esteban", 30, "1234", 300.0);
        accountRepository.createAccount(newAccount);
        assertEquals(3, accountRepository.getAllAccounts().size());
        assertTrue(accountRepository.getAllAccounts().contains(newAccount));
    }

    @Test
    public void testGetAllAccounts() {
        assertEquals(2, accountRepository.getAllAccounts().size());
        assertTrue(accountRepository.getAllAccounts().containsAll(accounts));
    }

    @Test
    public void testGetAccountById() {
        assertEquals(accounts.get(0), accountRepository.getAccountById(1));
        assertEquals(accounts.get(1), accountRepository.getAccountById(2));
        assertNull(accountRepository.getAccountById(3));
    }
}
