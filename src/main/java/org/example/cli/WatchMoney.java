package org.example.cli;

import java.util.Scanner;

import java.util.Scanner;

public class WatchMoney {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("----- Monedas Actuales -----");

        // Por ejemplo:
        System.out.print("Ingrese el monto a transferir: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Transferencia de " + monto + " realizada con éxito.");
    }
}



