package org.example.cli;

import java.util.Scanner;

import java.util.Scanner;

public class History {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("----- Transferencias -----");
        System.out.println("Aquí puedes realizar transferencias.");

        System.out.print("Ingrese el monto a transferir: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Transferencia de " + monto + " realizada con éxito.");
    }
}



