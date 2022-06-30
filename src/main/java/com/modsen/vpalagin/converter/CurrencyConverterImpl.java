package com.modsen.vpalagin.converter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CurrencyConverterImpl implements CurrencyConverter {

    public static final BigDecimal dollarToRubleExchangeRate = BigDecimal.valueOf(60.3);

    @Override
    public BigDecimal toDollars(BigDecimal ruble) {
        return ruble.divide(dollarToRubleExchangeRate, MathContext.DECIMAL32);
    }

    @Override
    public BigDecimal toRubles(BigDecimal dollar) {
        return dollar.multiply(dollarToRubleExchangeRate);
    }
}
