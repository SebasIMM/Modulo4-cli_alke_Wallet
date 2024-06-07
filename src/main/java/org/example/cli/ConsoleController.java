package org.example.cli;

import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.example.util.CsvUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private boolean sessionStarted = false;
    private final Scanner scan = new Scanner(System.in);

    private List<Account> accountsFromCsv;
    private AccountRepository accountRepository;

    public ConsoleController(List<Account> accountsFromCsv, AccountRepository accountRepository) {
        this.accountsFromCsv = accountsFromCsv;
        this.accountRepository = accountRepository;
    }

    public void showMainMenu() {
        do {
            if (!sessionStarted) {
                login();
            } else {
                showOptions();
            }
        } while (true);
    }

    private void login() {
        System.out.println("----- Iniciar Sesión -----");
        System.out.print("Usuario: ");
        String user = scan.nextLine();
        System.out.print("Clave: ");
        String pass = scan.nextLine();

        // Validate
        @NotNull List<Account> accountsFromCsv = CsvUtil.readAccountsFromCsv();

        for (Account account : accountsFromCsv) {
            if (account.getName().equals(user)) {
                if (account.getPassWd().equals(pass)) {
                    sessionStarted = true;
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
        System.out.println("1. Ver mis datos");
        System.out.println("2. Realizar Transferencias");
        System.out.println("3. Ver Monedas");
        System.out.println("4. Ver Historial Transferencia");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scan.nextInt();
        scan.nextLine();

        switch (opcion) {
            case 1:
                UserData user = new UserData();
                user.run();
                break;
            case 2:
                Transference transference = new Transference();
                transference.run();
                break;
            case 3:
                //CrearCuentas crearCuentas = new CrearCuentas();
                //crearCuentas.mostrarMenuCrearCuentas();
                break;
            case 4:
                //CrearCuentas crearCuentas = new CrearCuentas();
                //crearCuentas.mostrarMenuCrearCuentas();
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


