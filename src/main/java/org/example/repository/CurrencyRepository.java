package org.example.repository;

import org.example.model.Currency;

import java.util.List;

public interface CurrencyRepository {
    void createCurrency(Currency currency);

    void createCurrencies(List<Currency> currencies);

    List<Currency> getAllCurrencies();

    Currency getCurrencyByCode(String code);

    boolean updateCurrencyRate(Currency updatedCurrency);

    boolean deleteCurrency(Currency currencyToDelete);
}
