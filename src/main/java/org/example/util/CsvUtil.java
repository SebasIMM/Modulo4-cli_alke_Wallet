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
    private static final String csvCurrency = "src/main/resources/currencies.csv";
    private static final String csvTransaction = "src/main/resources/transactions.csv";

    // Accounts
    public static void writeAccountsToCsv(@NotNull List<Account> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvAccount))) {
            // Write header
            writer.write("id,name,age,passWd,balance");
            writer.newLine();

            // Write account data
            for (Account account : accounts) {
                writer.write(account.getId() + SEPARATOR +
                        account.getName() + SEPARATOR +
                        account.getAge() + SEPARATOR +
                        account.getPassWd() + SEPARATOR +
                        account.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }

    public static @NotNull List<Account> readAccountsFromCsv() {
        List<Account> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvAccount))) {
            String header = reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String passWd = data[3];
                double balance = Double.parseDouble(data[4]);
                accounts.add(new Account(id, name, age, passWd,balance));
            }
        } catch (IOException e) {
            System.err.println("Error reading from CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number from CSV: " + e.getMessage());
        }
        return accounts;
    }


    // Currency
    public static void writeCurrenciesToCsv(List<Currency> currencies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvCurrency, true))) {
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

        try (BufferedReader reader = new BufferedReader(new FileReader(csvCurrency))) {
            String header = reader.readLine();
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

    /*public static @NotNull List<Transaction> readTransactionsFromCsv() {
        List<Transaction> transactions = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader(csvTransaction))) {
            String header = reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                int id = Integer.parseInt(data[0]);
                Date date = dateFormat.parse(data[1]); // Convirtiendo la cadena en un objeto Date
                String currency = data[2];
                double amount = Double.parseDouble(data[3]);
                String type = data[4];
                String description = data[5];
                int idAccount = Integer.parseInt(data[6]);

                Transaction transaction = new Transaction(id, date, currency, amount, type, description, idAccount);
                transactions.add(transaction);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return transactions;
    }*/
    public static @NotNull List<Transaction> readTransactionsFromCsv() {
        List<Transaction> transactions = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader(csvTransaction))) {
            String header = reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(SEPARATOR);
                int id = Integer.parseInt(data[0]);
                Date date = dateFormat.parse(data[1]);
                String currency = data[2];
                double amount = Double.parseDouble(data[3]);
                String type = data[4];
                String description = data[5];
                int idAccount = Integer.parseInt(data[6]);

                transactions.add(new Transaction(id, date, currency, amount, type, description, idAccount));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return transactions;
    }


}
