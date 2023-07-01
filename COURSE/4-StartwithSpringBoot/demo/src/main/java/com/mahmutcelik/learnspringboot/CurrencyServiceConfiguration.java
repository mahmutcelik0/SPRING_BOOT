package com.mahmutcelik.learnspringboot;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
* application.properties dosyasından prefix i currency-service olan
* değerleri alıyor ve component oluşturuyor
* Bu bean i RESTController ile requestMappping yaptığımızda
* dönecek değerler application.properties de tanımladığımız default değerler olacak
* */

@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
