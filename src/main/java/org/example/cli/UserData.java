package org.example.cli;

import org.example.model.Account;
import org.example.repository.AccountRepository;

public class UserData {
    public void run(int userId, AccountRepository accountRepository) {
        Account userAccount = accountRepository.getAccountById(userId);

        try {
            if (userAccount != null) {
                System.out.println("----- Información de Usuario -----");
                System.out.printf("Nombre: %s%n", userAccount.getName());
                System.out.printf("Balance: %.2f%n", userAccount.getBalance());
                System.out.println("----------------------------------");
            } else {
                System.out.printf("No se encontró información para el usuario con ID: %s%n", userId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
