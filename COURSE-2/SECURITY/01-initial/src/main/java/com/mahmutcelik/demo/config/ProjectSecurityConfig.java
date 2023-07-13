package com.mahmutcelik.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.function.Function;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) //POST PUT DELETE PATCH YAPMAMIZI ENGELLIYORDU DISABLE ETTIK
                .authorizeHttpRequests(request->request.requestMatchers("/account/**","/balance/**","/loans/**","/cards/**").authenticated() // bu base deki endpointler authentication gerektiriyor
                .requestMatchers("/notices","/contact","/register").permitAll())    // bu base deki endpointler authentication gerekmiyor
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    //PROPERTIES DOSYASI YERINE CONFIG DOSYASINDA USER OLUSTURMUS OLDUK -- PRODUCTIONDA KULLANILMAZ
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails user2 = User.builder()
//                .username("mahmut")
//                .password("Mahmut2001")
//                .authorities("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(user2);
//    }
    /*
    * Default olarak DaoAuthenticationProvider kullanılıyor şuan. Ve bean olarak InMemoryUserDetailsManager oluşturduğumuz için
    * DaoAuthenticationProvider da User ları getirmek için InMemoryUserDetailsManager kullanılıyor - başka çeşitte bir UserDetailsManager yazarsak o kullanılır
    *
    * */

//    @Bean
//    public UserDetailsService userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource); // Datasource otomatik olarak db connection oluşturulduğunda oluşturulur.
//    }

    //PROJEDE KULLANILACAK PASSWORD ENCODER BEAN INI OLUSTURUR
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //DEPRECATED SOLUTION AND THIS DOESN'T MAKE ANY ENCRYPTION OR HASHING
    }



}
