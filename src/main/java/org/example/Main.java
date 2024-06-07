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
        AccountRepository accountRep = new AccountRepository();
        CurrencyRepository currencyRep = new CurrencyRepository();
        TransactionRepository transactionRep = new TransactionRepository();

        @NotNull List<Account> accountsFromCsv = CsvUtil.readAccountsFromCsv();
        @NotNull List<Currency> currenciesFromCsv = CsvUtil.readCurrenciesFromCsv();
        @NotNull List<Transaction> transactionsFromCsv = CsvUtil.readTransactionsFromCsv();


        //ConsoleController menu = new ConsoleController();
        //menu.showMainMenu();
    }
}