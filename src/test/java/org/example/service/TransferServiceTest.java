package org.example.service;

import org.example.model.Currency;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TransferServiceTest {
    private TransferService transferService;

    @Mock
    private Currency sourceCurrency;

    @Mock
    private Currency destinationCurrency;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        transferService = new TransferService();
    }

    @Test
    public void testConvertCurrency() {
        when(sourceCurrency.getRate()).thenReturn(1.0);
        when(destinationCurrency.getRate()).thenReturn(1.2);

        double amount = 10.0;
        double convertedAmount = transferService.convertCurrency(amount, sourceCurrency, destinationCurrency);

        assertEquals(12.0, convertedAmount, 0.01);    }
}
