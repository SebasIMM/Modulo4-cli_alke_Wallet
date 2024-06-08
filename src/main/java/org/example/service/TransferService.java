package org.example.service;

import org.example.model.Currency;

public class TransferService {
    public double convertCurrency(double amount, Currency sourceCurrency, Currency destinationCurrency) {
        return amount * (destinationCurrency.getRate() / sourceCurrency.getRate());
    }
}
