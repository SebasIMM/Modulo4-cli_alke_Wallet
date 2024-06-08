package org.example.cli;

import org.example.model.Account;
import org.example.repository.AccountRepository;

import java.util.Optional;

public class UserData {
    public void run(int userId, AccountRepository accountRepository) {
        Account userAccount = accountRepository.getAccountById(userId);

        if (userAccount != null) {
            System.out.println("----- Información del Usuario -----");
            System.out.println("ID: " + userAccount.getId());
            System.out.println("Nombre: " + userAccount.getName());
            System.out.println(userAccount.getAge());
            System.out.println(userAccount);
            // Mostrar otros detalles del usuario...
        } else {
            System.out.println("No se encontró información para el usuario con ID: " + userId);
        }
    }
}
