package org.example.cli;

import org.example.model.Transaction;
import org.example.repository.TransactionRepository;

import java.util.List;

public class History {
    public void run(int userId, TransactionRepository transactionRepository) {
        List<Transaction> transactions = transactionRepository.getTransactionsByIdAccount(userId);

        try {
            if (transactions != null && !transactions.isEmpty()) {
                System.out.println("---------- Historial de transferencias ----------");
                System.out.println();
                for (Transaction transaction : transactions) {
                    String formattedString = String.format("Fecha: %-20s | Moneda: %-5s | Monto: %10.2f",
                            transaction.getDate(), transaction.getCurrency(), transaction.getAmount());
                    System.out.println(formattedString);
                }
                System.out.println();
            } else {
                System.out.println("No se encontraron transacciones para el usuario con ID: " + userId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}