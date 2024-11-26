package com.example.rest;

import com.example.calculator.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final MessagePublisher messagePublisher;

    public CalculatorController(CalculatorService calculatorService, MessagePublisher messagePublisher) {
        this.calculatorService = calculatorService;
        this.messagePublisher = messagePublisher;
    }

    @GetMapping("/{operation}")
    public Map<String, Object> calculate(
            @PathVariable String operation,
            @RequestParam String a,
            @RequestParam String b) {

        BigDecimal numA = new BigDecimal(a);
        BigDecimal numB = new BigDecimal(b);

        BigDecimal result = calculatorService.calculate(numA, numB, operation);

        String message = String.format(
                "Operation: %s, A: %s, B: %s, Result: %s",
                operation, a, b, result
        );
        messagePublisher.sendMessage(message);

        Map<String, Object> response = new HashMap<>();
        response.put("result", result);
        return response;
    }
}
