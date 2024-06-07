package org.example.repository;

import org.example.model.Currency;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository {
    private final List<Currency> currencies = new ArrayList<>();

    // Create
    public void createCurrency(String code, String name, double rate) {
        Currency currency = new Currency(code, name, rate);
        currencies.add(currency);
    }

    // Read
    public List<Currency> getAllCurrencies() {
        return currencies;
    }

    // Update
    public void updateCurrencyRate(String code, double newRate) {
        for (Currency currency : currencies) {
            if (currency.getCode().equals(code)) {
                currency.setRate(newRate);
                return;
            }
        }
        System.out.println("Currency with code " + code + " not found.");
    }

    // Delete
    public void deleteCurrency(String code) {
        currencies.removeIf(currency -> currency.getCode().equals(code));
    }


}
