package org.example.cli;

import java.util.Scanner;

public class Transference {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("----- Transferencias -----");
        System.out.println("Aquí puedes realizar transferencias.");
        //Agrega aquí las opciones y lógica para las transferencias
        // Por ejemplo:
         System.out.print("Ingrese el monto a transferir: ");
         double monto = scanner.nextDouble();
         scanner.nextLine(); // Consumir el salto de línea
         System.out.println("Transferencia de " + monto + " realizada con éxito.");
    }
}


