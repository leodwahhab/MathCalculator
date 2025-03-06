package com.example.MathCalculator.math;

public class SimpleMath {
    public Double sum(Double numOne, Double numTwo) {
        return numOne + numTwo;
    }

    public Double sub(Double numOne, Double numTwo) {
        return numOne - numTwo;
    }

    public Double mult(Double numOne, Double numTwo) {
        return numOne * numTwo;
    }

    public Double div(Double numOne, Double numTwo) {
        if(numTwo != 0)
            return numOne / numTwo;
        else
            throw new ArithmeticException("impossível dividir um número por zero!");
    }

    public Double med(Double numOne, Double numTwo) {
        return (numOne + numTwo) / 2;
    }

    public Double sqrt(Double num) {
        return Math.sqrt(num);
    }
}
