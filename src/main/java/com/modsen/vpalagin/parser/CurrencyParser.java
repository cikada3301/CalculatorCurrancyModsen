package com.modsen.vpalagin.parser;

import com.modsen.vpalagin.calculator.Calculator;
import com.modsen.vpalagin.calculator.CurrencyCalculator;
import com.modsen.vpalagin.converter.CurrencyConverter;
import com.modsen.vpalagin.converter.CurrencyConverterImpl;

import java.math.BigDecimal;

public class CurrencyParser {

    private final Calculator calculator = new CurrencyCalculator();

    private final CurrencyConverter currencyConverter = new CurrencyConverterImpl();

    public String calculateTheAmountCurrency(String request) throws Exception {

        for (int i = 0; i < request.length(); i++) {
            if (request.charAt(i) == '(') {
                String substringMathOperation = request.substring(i + 1, request.length() - 1);
                if (request.substring(0, i).equals("toDollars")) {
                    String mathOperation = substringMathOperation;
                    if (mathOperation.contains("+")) {
                        String[] arrayMoney = mathOperation.split("[+]");
                        if (arrayMoney[0].endsWith("р") && arrayMoney[1].endsWith("р")) {
                            BigDecimal currency = calculator.calculateSumCurrency(new BigDecimal(arrayMoney[0].substring(0, arrayMoney[0].length() - 1)), new BigDecimal(arrayMoney[1].length() - 1));
                            return "$" + currencyConverter.toDollars(currency);
                        }
                    } else if (mathOperation.contains("-")) {
                        String[] arrayMoney = mathOperation.split("[-]");
                        if (arrayMoney[0].endsWith("р") && arrayMoney[1].endsWith("р")) {
                            BigDecimal currency = calculator.calculateTheDifferenceCurrency(new BigDecimal(arrayMoney[0].substring(0, arrayMoney[0].length() - 1)), new BigDecimal(arrayMoney[1].length() - 1));
                            return "$" + currencyConverter.toDollars(currency);
                        }
                    }
                    else if (!mathOperation.contains("-") && !mathOperation.contains("+")){
                        return currencyConverter.toRubles(new BigDecimal(request.substring(i + 1, request.length() - 2))) + "p";
                    }
                }
                else if(request.substring(0, i).equals("toRubles")) {
                    String mathOperation = substringMathOperation;
                    if (mathOperation.contains("+")) {
                        String[] arrayMoney = mathOperation.split("[+]");
                        if (arrayMoney[0].startsWith("$") && arrayMoney[1].startsWith("$")) {
                            BigDecimal currency = calculator.calculateSumCurrency(new BigDecimal(arrayMoney[0].substring(1)), new BigDecimal(arrayMoney[1].substring(1)));
                            System.out.println(currency);
                            return currencyConverter.toRubles(currency) + "p";
                        }
                    } else if (mathOperation.contains("-")) {
                        String[] arrayMoney = mathOperation.split("[-]");
                        if (arrayMoney[0].startsWith("$") && arrayMoney[1].startsWith("$")) {
                            BigDecimal currency = calculator.calculateTheDifferenceCurrency(new BigDecimal(arrayMoney[0].substring(1)), new BigDecimal(arrayMoney[1].substring(1)));
                            return currencyConverter.toRubles(currency) + "p";
                        }
                    }
                    else if (!mathOperation.contains("-") && !mathOperation.contains("+")){
                        return currencyConverter.toRubles(new BigDecimal(request.substring(i + 2, request.length() - 1))) + "p";
                    }
                }
            }
        }
        throw new Exception("Валюта указана не верно");
    }
}
