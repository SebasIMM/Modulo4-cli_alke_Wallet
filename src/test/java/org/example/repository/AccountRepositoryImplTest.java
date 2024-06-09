package org.example.repository;

import org.example.model.Account;
import org.example.repository.impl.AccountRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AccountRepositoryImplTest {
    private AccountRepositoryImpl accountRepositoryImpl;
    private List<Account> accounts;

    @Before
    public void setUp() {
        accountRepositoryImpl = new AccountRepositoryImpl();
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "Juan", 30, "1234", 100.0));
        accounts.add(new Account(2, "Claudia", 25, "1234", 200.0));
        accountRepositoryImpl.createAccounts(accounts);
    }

    @Test
    public void testCreateAccount() {
        Account newAccount = new Account(3, "Esteban", 30, "1234", 300.0);
        accountRepositoryImpl.createAccount(newAccount);
        assertEquals(3, accountRepositoryImpl.getAllAccounts().size());
        assertTrue(accountRepositoryImpl.getAllAccounts().contains(newAccount));
    }

    @Test
    public void testGetAllAccounts() {
        assertEquals(2, accountRepositoryImpl.getAllAccounts().size());
        assertTrue(accountRepositoryImpl.getAllAccounts().containsAll(accounts));
    }

    @Test
    public void testGetAccountById() {
        assertEquals(accounts.get(0), accountRepositoryImpl.getAccountById(1));
        assertEquals(accounts.get(1), accountRepositoryImpl.getAccountById(2));
        assertNull(accountRepositoryImpl.getAccountById(3));
    }
}
