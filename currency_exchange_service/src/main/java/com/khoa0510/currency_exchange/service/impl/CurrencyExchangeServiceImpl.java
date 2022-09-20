package com.khoa0510.currency_exchange.service.impl;

import com.khoa0510.currency_exchange.model.ExchangeValue;
import com.khoa0510.currency_exchange.repository.CurrencyExchangeRepository;
import com.khoa0510.currency_exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;

    public ExchangeValue getExchangeValue(String currency_from, String currency_to){
        ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(currency_from, currency_to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
        return exchangeValue;
    }
}
