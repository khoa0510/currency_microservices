package com.khoa0510.currency_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CurrencyCalculatorApplication {
    public static void main(String[] arg) {
        SpringApplication.run(CurrencyCalculatorApplication.class, arg);
    }
}
