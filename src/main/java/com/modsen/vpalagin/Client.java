package com.modsen.vpalagin;

import com.modsen.vpalagin.parser.CurrencyParser;

import java.math.BigDecimal;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        while(true) {
            String request = new Scanner(System.in).nextLine();

            CurrencyParser currencyParser = new CurrencyParser();

            try {
                System.out.println(currencyParser.calculateTheAmountCurrency(request));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
