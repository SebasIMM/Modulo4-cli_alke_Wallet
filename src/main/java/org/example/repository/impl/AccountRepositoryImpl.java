package org.example.repository.impl;

import org.example.model.Account;
import org.example.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    /**
     * Añade una nueva cuenta a la lista de cuentas
     * @param account (account) La cuenta a añadir
     * *
     * Añade una lista de cuentas a la lista de cuentas existente
     * @param accounts (List) La lista de cuentas a añadir
     * *
     * Obtiene todas las cuentas almacenadas en la lista
     * @return Una lista de todas las cuentas almacenadas
     * *
     * Obtiene una cuenta específica por su ID
     * @param accountId (int) El ID de la cuenta a buscar
     * @return La cuenta con el ID especificado, o null si no se encuentra
     * *
     * Actualiza la información de una cuenta existente
     * @param updatedAccount (Account) La cuenta actualizada
     * @return true si la cuenta se actualizó correctamente, false si no se encontró la cuenta
     * *
     * Elimina una cuenta por su ID
     * @param accountId (int) El ID de la cuenta a eliminar
     * @return true si la cuenta se eliminó correctamente, false si no se encontró la cuenta
     */

    // Create
    @Override
    public void createAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void createAccounts(List<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    // Get
    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account getAccountById(int accountId) {
        for (Account acc : accounts) {
            if (acc.getId() == accountId) {
                return acc;
            }
        }
        return null;
    }

    // Update
    @Override
    public boolean updateAccount(Account updatedAccount) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getId() == updatedAccount.getId()) {
                accounts.set(i, updatedAccount);
                System.out.println("Cuenta actualizada: " + updatedAccount);
                return true;
            }
        }
        System.out.println("Cuenta con el id " + updatedAccount.getId() + " no encontrada");
        return false;
    }

    // Delete
    @Override
    public boolean deleteAccount(int accountId) {
        Account account = getAccountById(accountId);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Cuenta eliminada: " + account);
            return true;
        } else {
            System.out.println("Cuenta no encontrada");
            return false;
        }
    }
}
