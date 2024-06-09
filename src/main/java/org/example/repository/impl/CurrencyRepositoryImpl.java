package org.example.repository.impl;

import org.example.model.Currency;
import org.example.repository.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRepositoryImpl implements CurrencyRepository {
    private final List<Currency> currencies = new ArrayList<>();

    @Override
    public void createCurrency(Currency currency) {
        currencies.add(currency);
    }

    @Override
    public void createCurrencies(List<Currency> currencies) {
        this.currencies.addAll(currencies);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencies;
    }

    @Override
    public Currency getCurrencyByCode(String code) {
        for (Currency currency : currencies) {
            if (currency.getCode().equals(code)) {
                return currency;
            }
        }
        return null;
    }

    @Override
    public boolean updateCurrencyRate(Currency updatedCurrency) {
        Currency currencyLocate = getCurrencyByCode(updatedCurrency.getCode());
        if (currencyLocate != null) {
            currencyLocate.setName(updatedCurrency.getName());
            currencyLocate.setRate(updatedCurrency.getRate());
            return true;
        } else {
            System.out.println("Moneda con el código " + updatedCurrency.getCode() + " no encontrada.");
            return false;
        }
    }

    @Override
    public boolean deleteCurrency(Currency currencyToDelete) {
        return currencies.remove(currencyToDelete);
    }
}
