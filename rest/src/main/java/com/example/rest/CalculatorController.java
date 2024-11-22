package com.example.rest;

import com.example.calculator.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/{operation}")
    public BigDecimal calculate(@PathVariable String operation,
                                @RequestParam String a,
                                @RequestParam String b) {
        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);
        return calculatorService.calculate(numA, numB, operation);
    }
}