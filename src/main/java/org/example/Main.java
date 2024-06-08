package org.example;

import org.example.cli.ConsoleController;
import org.example.model.Account;
import org.example.model.Currency;
import org.example.model.Transaction;
import org.example.repository.AccountRepository;
import org.example.repository.CurrencyRepository;
import org.example.repository.TransactionRepository;
import org.example.util.CsvUtil;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Accounts List
        @NotNull List<Account> accountsFromCsv = CsvUtil.readAccountsFromCsv();
        AccountRepository accountRep = new AccountRepository();
        accountRep.createAccounts(accountsFromCsv);

        // Currencies List
        List<Currency> currenciesFromCsv = CsvUtil.readCurrenciesFromCsv();
        CurrencyRepository currencyrep = new CurrencyRepository();
        currencyrep.createCurrencies(currenciesFromCsv);

        // Transactions List
        List<Transaction> transactionsFromCsv = CsvUtil.readTransactionsFromCsv();
        TransactionRepository transactionRep = new TransactionRepository();
        transactionRep.createTransactions(transactionsFromCsv);

        // Start cli
        ConsoleController menu = new ConsoleController(accountsFromCsv, accountRep,
                                                        currenciesFromCsv, currencyrep,
                                                        transactionsFromCsv, transactionRep);
        menu.showMainMenu();
    }
}