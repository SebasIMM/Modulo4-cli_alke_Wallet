package org.example.cli;

import org.example.model.Currency;
import org.example.repository.impl.CurrencyRepositoryImpl;

import java.util.List;

public class CurrencyToday {
    public void run(CurrencyRepositoryImpl currencyRepositoryImpl) {
        List<Currency> currencies = currencyRepositoryImpl.getAllCurrencies();

        try {
            if (currencies != null && !currencies.isEmpty()) {
                System.out.println("------------------ Monedas al día ------------------");
                for (Currency currency : currencies) {
                    String formattedString = String.format("Moneda: %-4s | %-25s | %-10.4f",
                            currency.getCode(), currency.getName(), currency.getRate());
                    System.out.println(formattedString);
                    System.out.println("----------------------------------------------------");
                }
            } else {
                System.out.println("Error al mostrar las monedas de hoy");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
