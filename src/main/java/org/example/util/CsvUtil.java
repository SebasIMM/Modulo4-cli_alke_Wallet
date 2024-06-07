package org.example.util;

import org.example.model.Account;
import org.example.model.Currency;
import org.example.model.Transaction;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CsvUtil {
    private static final String SEPARATOR = ",";
    private static final String csvAccount = "src/main/resources/accounts.csv";
    private static final String csvcurrencie = "src/main/resources/currencies.csv";
    private static final String csvTransaction = "src/main/resources/transactions.csv";

    // Accounts

    public static void writeAccountsToCsv(List<Account> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvAccount, true))) {
            for (Account account : accounts) {
                writer.write(account.getId() + SEPARATOR + account.getName() + SEPARATOR + account.getAge());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static @NotNull List<Account> readAccountsFromCsv() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvAccount))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                accounts.add(new Account(id, name, age));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return accounts;
    }

    // Currency

    public static void writeCurrenciesToCsv(List<Currency> currencies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvcurrencie, true))) {
            for (Currency currency : currencies) {
                writer.write(currency.getCode() + SEPARATOR + currency.getName() + SEPARATOR + currency.getRate());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static @NotNull List<Currency> readCurrenciesFromCsv() {
        List<Currency> currencies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvcurrencie))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                String code = data[0];
                String name = data[1];
                double rate = Double.parseDouble(data[2]);
                currencies.add(new Currency(code, name, rate));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return currencies;
    }

    // Transaction

    public static void writeTransactionsToCsv(List<Transaction> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvTransaction, true))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getId() + SEPARATOR + transaction.getDate() + SEPARATOR + transaction.getCurrency() +
                        SEPARATOR + transaction.getAmount() + SEPARATOR + transaction.getType() + SEPARATOR +
                        transaction.getDescription() + SEPARATOR + transaction.getAccountId());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static @NotNull List<Transaction> readTransactionsFromCsv() {
        List<Transaction> transactions = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader(csvTransaction))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                int id = Integer.parseInt(data[0]);
                Date date = dateFormat.parse(data[1]);
                String currency = data[2];
                double amount = Double.parseDouble(data[3]);
                String type = data[4];
                String description = data[5];
                int accountId = Integer.parseInt(data[6]);

                Transaction transaction = new Transaction(id, date, currency, amount, type, description, accountId);
                transactions.add(transaction);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return transactions;
    }
}
