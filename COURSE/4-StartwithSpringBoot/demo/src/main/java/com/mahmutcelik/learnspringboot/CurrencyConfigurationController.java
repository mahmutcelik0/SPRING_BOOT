package com.mahmutcelik.learnspringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping(value = "/currency-configuration")
    public CurrencyServiceConfiguration returnMethod(){
        return configuration;
    }

}
