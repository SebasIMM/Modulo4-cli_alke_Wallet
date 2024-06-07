package org.example.cli;

import java.util.Scanner;

public class ConsoleController {
    private boolean sessionStarted = false;
    private Scanner scan = new Scanner(System.in);

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
        String usuario = scan.nextLine();
        System.out.print("Clave: ");
        String clave = scan.nextLine();

        // Aquí puedes agregar la lógica para validar el usuario y la clave
        sessionStarted = true;
        System.out.println("Sesión iniciada correctamente.\n");
    }

    private void showOptions() {
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Realizar Transferencias");
        System.out.println("2. Ver Monedas");
        System.out.println("4. Ver Historial Transferencia");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scan.nextInt();
        scan.nextLine();

        switch (opcion) {
            case 1:
                Transference transference = new Transference();
                transference.run();
                break;
            case 2:
                //CrearCuentas crearCuentas = new CrearCuentas();
                //crearCuentas.mostrarMenuCrearCuentas();
                break;
            case 3:
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


