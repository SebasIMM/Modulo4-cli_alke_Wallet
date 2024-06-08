package org.example.repository;

import org.example.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    // Create
    public void createTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void createTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }


    // Read
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public List<Transaction> getTransactionsByIdAccount(int idAccount) {
        return transactions.stream()
                .filter(tra -> tra.getIdAccount() == idAccount)
                .collect(Collectors.toList());
    }
}
