package com.example.MathCalculator.request.converters;

import com.example.MathCalculator.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static boolean isNumeric(String str) {
        if(str == null || str.isEmpty()) return false;
        String number = str.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

    public static Double toDouble(String string){
        if(isNumeric(string) || string.isEmpty())
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
        String number = string.replace(",", ".");
        return Double.parseDouble(number);
    }
}
