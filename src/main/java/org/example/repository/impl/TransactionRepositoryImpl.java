package org.example.repository.impl;

import org.example.model.Transaction;
import org.example.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void createTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void createTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionsByIdAccount(int idAccount) {
        List<Transaction> transactionsByIdAccount = new ArrayList<>();
        for (Transaction tra : transactions) {
            if (tra.getIdAccount() == idAccount) {
                transactionsByIdAccount.add(tra);
            }
        }
        return transactionsByIdAccount;
    }
}
