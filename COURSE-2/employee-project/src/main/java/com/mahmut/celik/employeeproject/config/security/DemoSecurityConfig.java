package com.mahmut.celik.employeeproject.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id =?"
        );

        userDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id =?"
        );

        return new JdbcUserDetailsManager(dataSource);
        //Tell Spring Security to use JDBC authentication with our data source
    }


    //KENDI SECURITY FILTER CHAIN IMIZI OLUSTURDUK - HttpSecurity ye authorization, basic login ve csrf disable verdik ve build ettik
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/v1/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/v1/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/v1/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/v1/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/employees/**").hasRole("ADMIN")
        );

        //USE BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());

        //DISABLE CSRF
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    /*
    * @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                            .username("john")
                            .password("{noop}test123")
                            .roles("EMPLOYEE")
                            .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john,mary,susan);
    }
    *
    * */
}
