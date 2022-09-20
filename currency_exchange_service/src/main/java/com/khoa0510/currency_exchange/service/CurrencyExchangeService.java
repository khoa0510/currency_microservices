package com.khoa0510.currency_exchange.service;

import com.khoa0510.currency_exchange.model.ExchangeValue;

public interface CurrencyExchangeService {
    ExchangeValue getExchangeValue(String currency_from, String currency_to);
}
