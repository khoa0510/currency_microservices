package com.khoa0510.currency_calculator.service.Impl;

import com.khoa0510.currency_calculator.model.CalculatedAmount;
import com.khoa0510.currency_calculator.service.CurrencyCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyCalculationServiceImpl implements CurrencyCalculationService {
    @Autowired
    RestTemplate restTemplate;

    public CalculatedAmount getCalculatedAmount(String from, String to, BigDecimal quantity) {
        CalculatedAmount calculatedAmount = restTemplate.getForObject("currency_exchange/from/{from}/to/{to}", CalculatedAmount.class);
        calculatedAmount.setQuantity(quantity);
        calculatedAmount.setTotalCalculatedAmount(calculatedAmount.getConversionMultiple().multiply(quantity));
        return calculatedAmount;
    }
}