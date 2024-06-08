package org.example.repository;

import org.example.model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrencyRepository {
    private final List<Currency> currencies = new ArrayList<>();

    // Create
    public void createCurrency(Currency currency) {
        currencies.add(currency);
    }

    public void createCurrencies(List<Currency> currencies) {
        this.currencies.addAll(currencies);
    }


    // Read
    public List<Currency> getAllCurrencies() {
        return currencies;
    }

    public Optional<Currency> getCurrencyByCode(String code) {
        return currencies.stream()
                .filter(currency -> currency.getCode().equals(code))
                .findFirst();
    }

    // Update
    public boolean updateCurrencyRate(Currency updatedCurrency) {
        Optional<Currency> currencyLocate = getCurrencyByCode(updatedCurrency.getCode());
        if (currencyLocate.isPresent()) {
            Currency currency = currencyLocate.get();
            currency.setName(updatedCurrency.getName());
            currency.setRate(updatedCurrency.getRate());
            return true;
        } else {
            System.out.println("Moneda con el código " + updatedCurrency.getCode() + " no encontrada.");
            return false;
        }
    }

    // Delete
    public boolean deleteCurrency(Currency currencyToDelete) {
        return currencies.remove(currencyToDelete);
    }
}
