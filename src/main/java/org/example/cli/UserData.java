package org.example.cli;

import org.example.model.Account;
import org.example.repository.impl.AccountRepositoryImpl;

public class UserData {
    public void run(int userId, AccountRepositoryImpl accountRepositoryImpl) {
        Account userAccount = accountRepositoryImpl.getAccountById(userId);

        try {
            if (userAccount != null) {
                System.out.println("----- Información de Usuario -----\n");
                System.out.printf(" Nombre: %s%n", userAccount.getName());
                System.out.printf(" Balance: %.2f%n\n", userAccount.getBalance());
                System.out.println("----------------------------------");
            } else {
                System.out.printf("No se encontró información para el usuario con ID: %s%n", userId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
