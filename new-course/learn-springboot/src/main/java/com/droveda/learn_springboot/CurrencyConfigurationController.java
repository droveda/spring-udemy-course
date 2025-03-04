package com.droveda.learn_springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    private final CurrencyServiceConfiguration currencyServiceConfiguration;

    public CurrencyConfigurationController(CurrencyServiceConfiguration currencyServiceConfiguration) {
        this.currencyServiceConfiguration = currencyServiceConfiguration;
    }

    @GetMapping("/currency")
    public ResponseEntity<CurrencyServiceConfiguration> getCourses() {

        return ResponseEntity.ok(currencyServiceConfiguration);

    }

}
