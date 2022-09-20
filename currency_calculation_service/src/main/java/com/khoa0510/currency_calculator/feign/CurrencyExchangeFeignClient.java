package com.khoa0510.currency_calculator.feign;

import com.khoa0510.currency_calculator.model.CalculatedAmount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyExchangeFeignClient {
    @GetMapping("/currency_exchange/from/{from}/to/{to}")
    CalculatedAmount getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}