package org.example.repository;

import org.example.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    void createTransaction(Transaction transaction);

    void createTransactions(List<Transaction> transactions);

    List<Transaction> getAllTransactions();

    List<Transaction> getTransactionsByIdAccount(int idAccount);
}