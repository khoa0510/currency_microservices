package com.khoa0510.currency_exchange.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="EXCHANGE_VALUE")
@Getter
@Setter
public class ExchangeValue {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name = "port")
    private int port;
}
