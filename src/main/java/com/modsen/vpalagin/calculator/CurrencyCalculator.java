package com.modsen.vpalagin.calculator;

import java.math.BigDecimal;

public class CurrencyCalculator implements Calculator {

    @Override
    public BigDecimal calculateSumCurrency(BigDecimal currency, BigDecimal currentSum) {
        return currentSum.add(currency);
    }

    @Override
    public BigDecimal calculateTheDifferenceCurrency(BigDecimal currency, BigDecimal currentSum) {
        return currentSum.subtract(currency);
    }
}
