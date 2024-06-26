package org.example.cli;

import org.example.model.Account;
import org.example.model.Currency;
import org.example.model.Transaction;
import org.example.repository.impl.AccountRepositoryImpl;
import org.example.repository.impl.CurrencyRepositoryImpl;
import org.example.repository.impl.TransactionRepositoryImpl;
import org.example.service.TransferService;
import org.example.util.CsvUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private boolean sessionStarted = false;
    private final Scanner scan = new Scanner(System.in);

    private List<Account> accountsFromCsv;
    private AccountRepositoryImpl accountRepositoryImpl;
    private List<Currency> currenciesFromCsv;
    private CurrencyRepositoryImpl currencyRepositoryImpl;
    private List<Transaction> transactionsFromCsv;
    private TransactionRepositoryImpl transactionRepositoryImpl;

    public ConsoleController(List<Account> accountsFromCsv, AccountRepositoryImpl accountRepositoryImpl,
                             List<Currency> currenciesFromCsv, CurrencyRepositoryImpl currencyRepositoryImpl,
                             List<Transaction> transactionsFromCsv, TransactionRepositoryImpl transactionRepositoryImpl) {
        this.accountsFromCsv = accountsFromCsv;
        this.accountRepositoryImpl = accountRepositoryImpl;
        this.currenciesFromCsv = currenciesFromCsv;
        this.currencyRepositoryImpl = currencyRepositoryImpl;
        this.transactionsFromCsv = transactionsFromCsv;
        this.transactionRepositoryImpl = transactionRepositoryImpl;
    }

    public void showMainMenu() {
        do {
            if (!sessionStarted) {
                login();
            } else {
                System.out.println("Presiona Enter para continuar...");
                scan.nextLine();
                showOptions();
            }
        } while (true);
    }

    int userId;
    private void login() {
        System.out.println("----- Iniciar Sesión -----");
        System.out.print("Usuario (sebas): ");
        String user = scan.nextLine();
        System.out.print("Clave (1234): ");
        String pass = scan.nextLine();

        // Validate
        @NotNull List<Account> accountsFromCsv = CsvUtil.readAccountsFromCsv();
        for (Account account : accountsFromCsv) {
            if (account.getName().equals(user)) {
                if (account.getPassWd().equals(pass)) {
                    sessionStarted = true;
                    userId = account.getId();
                    System.out.println("Sesión iniciada correctamente.\n");
                } else {
                    System.out.println("Contraseña incorrecta. Por favor, inicie sesión nuevamente.\n");
                }
                break;
            }
        }
    }

    private void showOptions() {
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Ver Balance");
        System.out.println("2. Realizar Transferencias");
        System.out.println("3. Ver Historial Transferencia");
        System.out.println("4. Ver Monedas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scan.nextInt();
        scan.nextLine();

        switch (opcion) {
            case 1:
                UserData user = new UserData();
                user.run(userId, accountRepositoryImpl);
                break;
            case 2:
                TransferService transferService = new TransferService();
                Transference transference = new Transference(transferService);
                transference.run(currencyRepositoryImpl);
                break;
            case 3:
                History history = new History();
                history.run(userId, transactionRepositoryImpl);
                break;
            case 4:
                CurrencyToday currency = new CurrencyToday();
                currency.run(currencyRepositoryImpl);
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }
}


