package com.mahmutcelik.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    //Custom security requirement lari bu kısımda tanımlayarak web app i secure etmiş oluruz
    //Yani basic auth isteniyorsa veya jwt auth isteniyorsa bu kısımda filter chain e ekleme yaparız ve bu sayede gelen http requestte o security de sağlanmış olunur

    // INITIAL
    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
    * */

    // /account ile /account/** arasindaki fark -> /account dediğimizde sadece o pathten gelen request ler dikkate alınırken /account/** base i account olan tüm request leri dikkate alır
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request->request.requestMatchers("/account/**","/balance/**","/loans/**","/cards/**").authenticated() // bu base deki endpointler authentication gerektiriyor
                .requestMatchers("/notices","/contact").permitAll())    // bu base deki endpointler authentication gerekmiyor
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();


        //DENY ALL lu - production için önerilmez - Önce credential gireriz sonrasında authentication başarılı olsa da authorization başarısız olur ve 403 döner
        /*
        http.authorizeHttpRequests(request->request.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();

        * */
    }



}
