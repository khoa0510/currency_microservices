package com.khoa0510.currency_calculator.service.Impl;

import com.khoa0510.currency_calculator.feign.CurrencyExchangeFeignClient;
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

    @Autowired
    CurrencyExchangeFeignClient currencyExchangeFeignClient;

    public CalculatedAmount getCalculatedAmount(String from, String to, BigDecimal quantity) {
        String url = "http://currency-exchange-service/currency_exchange/from/"+from+"/to/"+to;
        CalculatedAmount calculatedAmount = restTemplate.getForObject(url, CalculatedAmount.class);
        calculatedAmount.setQuantity(quantity);
        calculatedAmount.setTotalCalculatedAmount(calculatedAmount.getConversionMultiple().multiply(quantity));
        return calculatedAmount;
    }

    public CalculatedAmount getCalculatedAmountWithFeign(String from, String to, BigDecimal quantity) {
        CalculatedAmount calculatedAmount = currencyExchangeFeignClient.getExchangeValue(from, to);
        calculatedAmount.setQuantity(quantity);
        calculatedAmount.setTotalCalculatedAmount(calculatedAmount.getConversionMultiple().multiply(quantity));
        return calculatedAmount;
    }
}
