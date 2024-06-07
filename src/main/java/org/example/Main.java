package org.example;

import org.example.cli.ConsoleController;
import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.example.util.CsvUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Account List
        @NotNull List<Account> accountsFromCsv = CsvUtil.readAccountsFromCsv();
        AccountRepository accountRep = new AccountRepository();
        accountRep.createAccounts(accountsFromCsv);
        // Currency List


        ConsoleController menu = new ConsoleController(accountsFromCsv, accountRep);
        menu.showMainMenu();
    }
}