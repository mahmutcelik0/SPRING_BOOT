package com.example.oauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)http.authorizeHttpRequests().anyRequest()).authenticated();
//        http.formLogin();
//        http.httpBasic();
        http.oauth2Login(Customizer.withDefaults());
        /*
        * USTTEKINI YAPTIGIMIZ ZAMAN ERROR ALACAGIZ CUNKU SPRING BOOT API CLIENT OLUYOR VE USER IN GOOGLE DRIVE DAKI DOSYALARINA ERISMEK ISTIYORUZ
        * CREDENTIALS LARI OLUSTURMAMIZ GEREKIYOR --> GOOGLE API CONSOLE
        * */
        return (SecurityFilterChain)http.build();
    }

}
