package com.example.calculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class CalculatorService {
    public BigDecimal calculate(BigDecimal a, BigDecimal b, String operation) {
        switch (operation) {
            case "sum":
                return a.add(b);
            case "subtract":
                return a.subtract(b);
            case "multiply":
                return a.multiply(b);
            case "divide":
                if (b.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a.divide(b, 50, RoundingMode.HALF_UP);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
