package com.modsen.vpalagin.calculator;

import java.math.BigDecimal;

public interface Calculator {
    BigDecimal calculateSumCurrency(BigDecimal currency, BigDecimal currentSum);
    BigDecimal calculateTheDifferenceCurrency(BigDecimal currency, BigDecimal currentSum);
}
