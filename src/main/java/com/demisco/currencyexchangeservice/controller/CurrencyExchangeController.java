package com.demisco.currencyexchangeservice.controller;

import com.demisco.currencyexchangeservice.model.CurrencyExchange;
import com.demisco.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrency(@PathVariable String from, @PathVariable String to){
        logger.info("currency-exchange api {} to {}", from , to);
        CurrencyExchange response = currencyExchangeRepository.findByFromAndTo(from, to);
        return response;

//        return  new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));
    }
}
