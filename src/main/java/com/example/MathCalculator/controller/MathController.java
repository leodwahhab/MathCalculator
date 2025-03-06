package com.example.MathCalculator.controller;

import com.example.MathCalculator.exception.UnsupportedMathOperationException;
import com.example.MathCalculator.math.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.MathCalculator.request.converters.NumberConverter.isNumeric;
import static com.example.MathCalculator.request.converters.NumberConverter.toDouble;

@RestController
@RequestMapping("/math")
public class MathController {

    SimpleMath math = new SimpleMath();

    @GetMapping("/sum/{numOne}/{numTwo}")
    public Double sum(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return math.sum(toDouble(numOne), toDouble(numTwo));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/sub/{numOne}/{numTwo}")
    public Double sub(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return math.sub(toDouble(numOne), toDouble(numTwo));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/mult/{numOne}/{numTwo}")
    public Double mult(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return math.mult(toDouble(numOne), toDouble(numTwo));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/div/{numOne}/{numTwo}")
    public Double div(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return math.div(toDouble(numOne), toDouble(numTwo));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/med/{numOne}/{numTwo}")
    public Double med(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && isNumeric(numTwo))
            return math.med(toDouble(numOne), toDouble(numTwo));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico válido!");
    }

    @GetMapping("/sqrt/{num}")
    public Double sqrt(@PathVariable("num") String numOne) throws UnsupportedMathOperationException {
        if(isNumeric(numOne) && toDouble(numOne) != 0)
            return math.sqrt(toDouble(numOne));
        else
            throw new UnsupportedMathOperationException("digite um valor numérico diferente de zero!");
    }
}
