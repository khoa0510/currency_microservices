package com.khoa0510.currency_exchange.controller;

import com.khoa0510.currency_exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency_exchange")
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("from/{from}/to/{to}")
    public ResponseEntity<?> getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to){
        return ResponseEntity.ok(currencyExchangeService.getExchangeValue(from, to));
    }
}
