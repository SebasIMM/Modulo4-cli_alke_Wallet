package org.example.cli;

import org.example.model.Currency;
import org.example.repository.impl.CurrencyRepositoryImpl;
import org.example.service.TransferService;

import java.util.List;
import java.util.Scanner;

public class Transference {
    private final Scanner scan = new Scanner(System.in);
    private final TransferService transferService;

    public Transference(TransferService transferService) {
        this.transferService = transferService;
    }

    public void run(CurrencyRepositoryImpl currencyRepositoryImpl) {
        List<Currency> currencies = currencyRepositoryImpl.getAllCurrencies();

        System.out.println("Seleccione la moneda de origen:");
        displayCurrencies(currencies);
        int sourceIndex = scan.nextInt();

        System.out.println("Ingrese la cantidad a convertir:");
        double amount = scan.nextDouble();

        System.out.println("Seleccione la moneda de destino:");
        displayCurrencies(currencies);
        int destinationIndex = scan.nextInt();

        Currency sourceCurrency = currencies.get(sourceIndex - 1);
        Currency destinationCurrency = currencies.get(destinationIndex - 1);

        double result = transferService.convertCurrency(amount, sourceCurrency, destinationCurrency);
        System.out.printf("%.2f %s equivalen a %.2f %s%n", amount, sourceCurrency.getCode(), result, destinationCurrency.getCode());
    }

    private void displayCurrencies(List<Currency> currencies) {
        for (int i = 0; i < currencies.size(); i++) {
            Currency currency = currencies.get(i);
            System.out.printf("%d. %s (%s)%n", i + 1, currency.getName(), currency.getCode());
        }
    }

    private double convertCurrency(double amount, Currency sourceCurrency, Currency destinationCurrency) {
        return amount * (destinationCurrency.getRate() / sourceCurrency.getRate());
    }
}


