package com.khoa0510.currency_calculator.controller;

import com.khoa0510.currency_calculator.model.CalculatedAmount;
import com.khoa0510.currency_calculator.service.CurrencyCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency_calculation")
public class CurrencyCalculationController {
    @Autowired
    CurrencyCalculationService currencyCalculationService;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<?> getCalculatedAmount(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("quantity") BigDecimal quantity){
        return ResponseEntity.ok(currencyCalculationService.getCalculatedAmount(from, to, quantity));
    }
}
