package com.modsen.vpalagin.converter;

import java.math.BigDecimal;

public interface CurrencyConverter {
    BigDecimal toDollars(BigDecimal money);
    BigDecimal toRubles(BigDecimal money);
}
