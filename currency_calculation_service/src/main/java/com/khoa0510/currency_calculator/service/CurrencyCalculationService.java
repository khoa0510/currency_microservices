package com.khoa0510.currency_calculator.service;

import com.khoa0510.currency_calculator.model.CalculatedAmount;

import java.math.BigDecimal;

public interface CurrencyCalculationService {
    CalculatedAmount getCalculatedAmount(String from, String to, BigDecimal quantity);
    CalculatedAmount getCalculatedAmountWithFeign(String from, String to, BigDecimal quantity);
}
