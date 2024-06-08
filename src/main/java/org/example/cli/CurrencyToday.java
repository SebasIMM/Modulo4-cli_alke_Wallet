package org.example.cli;

import org.example.model.Currency;
import org.example.repository.CurrencyRepository;

import java.util.List;

public class CurrencyToday {
    public void run(CurrencyRepository currencyRepository) {
        List<Currency> currencies = currencyRepository.getAllCurrencies();

        try {
            if (currencies != null && !currencies.isEmpty()) {
                System.out.println("------------------ Monedas al día ------------------");
                System.out.println();
                for (Currency currency : currencies) {
                    String formattedString = String.format("Moneda: %-4s | %-25s | %-10.4f",
                            currency.getCode(), currency.getName(), currency.getRate());
                    System.out.println(formattedString);
                    System.out.println("---------------------------------------------------");
                }
            } else {
                System.out.println("Error al mostrar las monedas de hoy");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
