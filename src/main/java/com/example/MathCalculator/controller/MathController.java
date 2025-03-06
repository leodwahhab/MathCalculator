package com.example.MathCalculator.controller;

import com.example.MathCalculator.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{numOne}/{numTwo}")
    public Double sum(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return Double.parseDouble(numOne) + Double.parseDouble(numTwo);
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/sub/{numOne}/{numTwo}")
    public Double sub(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return Double.parseDouble(numOne) - Double.parseDouble(numTwo);
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/mult/{numOne}/{numTwo}")
    public Double mult(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return Double.parseDouble(numOne) * Double.parseDouble(numTwo);
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/div/{numOne}/{numTwo}")
    public Double div(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            if(Double.parseDouble(numTwo) != 0)
                return Double.parseDouble(numOne) / Double.parseDouble(numTwo);
            else
                throw new ArithmeticException("impossível dividir um número por zero!");
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/med/{numOne}/{numTwo}")
    public Double med(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return (Double.parseDouble(numOne) + Double.parseDouble(numTwo)) / 2;
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/sqrt/{num}")
    public Double sqrt(@PathVariable("num") String numOne) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && Double.parseDouble(numOne) != 0)
            return Math.sqrt(Double.parseDouble(numOne));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico diferente de zero!");
    }

    private boolean isNumeric(String str) {
        if(str == null || str.isEmpty()) return false;
        String number = str.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
