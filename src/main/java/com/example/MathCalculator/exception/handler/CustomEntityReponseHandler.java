package com.example.MathCalculator.exception.handler;

import com.example.MathCalculator.exception.ExceptionReponse;
import com.example.MathCalculator.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice // define que é uma classe de tratamento global de exceções
public class CustomEntityReponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) //anotação declara um bean de exceção e espera o tipo de exceção que a chamará
    public final ResponseEntity<ExceptionReponse> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionReponse response = new ExceptionReponse(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class) //anotação declara um bean de exceção e espera o tipo de exceção que a chamará
    public final ResponseEntity<ExceptionReponse> handleBadRequestExceptions(Exception exception, WebRequest request) {
        ExceptionReponse response = new ExceptionReponse(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public final ResponseEntity<ExceptionReponse> handleDivisionByZeroException(Exception exception, WebRequest request) {
        ExceptionReponse response = new ExceptionReponse(
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
