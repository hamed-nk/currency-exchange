package com.demisco.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/simple-api")
    @Retry(name = "simple-api", fallbackMethod = "hardBack")
    public String sampleApi() {
        logger.info("simple api run");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("localhost:8080/simple-api", String.class);
        return forEntity.getBody();
//        return "Sample Api";
    }

    public String hardBack(Exception ex){
        return "server is down";
    }
}
