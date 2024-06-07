package org.example.repository;

import org.example.model.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    // Create
    public void createTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Read
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public Optional<Transaction> getTransactionsByIdAccount(int id){
        return transactions.stream().filter(tra -> tra.getId() ==id).findFirst();
    }

    // Delete
    public void deleteTransaction(int idAccount) {
        transactions.removeIf(transaction -> transaction.getId() == idAccount);
    }
}
