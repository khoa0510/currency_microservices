package com.khoa0510.currency_exchange.service.impl;

import com.khoa0510.currency_exchange.model.ExchangeValue;
import com.khoa0510.currency_exchange.repository.CurrencyExchangeRepository;
import com.khoa0510.currency_exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    public ExchangeValue getExchangeValue(String currency_from, String currency_to){
        return currencyExchangeRepository.findByFromAndTo(currency_from, currency_to);
    }
}
