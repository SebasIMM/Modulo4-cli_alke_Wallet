package org.example;

import org.example.cli.ConsoleController;
import org.example.model.Account;
import org.example.model.Currency;
import org.example.model.Transaction;
import org.example.repository.impl.AccountRepositoryImpl;
import org.example.repository.impl.CurrencyRepositoryImpl;
import org.example.repository.impl.TransactionRepositoryImpl;
import org.example.util.CsvUtil;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Accounts List
        @NotNull List<Account> accountsFromCsv = CsvUtil.readAccountsFromCsv();
        AccountRepositoryImpl accountRep = new AccountRepositoryImpl();
        accountRep.createAccounts(accountsFromCsv);

        // Currencies List
        List<Currency> currenciesFromCsv = CsvUtil.readCurrenciesFromCsv();
        CurrencyRepositoryImpl currencyrep = new CurrencyRepositoryImpl();
        currencyrep.createCurrencies(currenciesFromCsv);

        // Transactions List
        List<Transaction> transactionsFromCsv = CsvUtil.readTransactionsFromCsv();
        TransactionRepositoryImpl transactionRep = new TransactionRepositoryImpl();
        transactionRep.createTransactions(transactionsFromCsv);

        // Start cli
        ConsoleController menu = new ConsoleController(accountsFromCsv, accountRep,
                                                        currenciesFromCsv, currencyrep,
                                                        transactionsFromCsv, transactionRep);
        menu.showMainMenu();
    }
}