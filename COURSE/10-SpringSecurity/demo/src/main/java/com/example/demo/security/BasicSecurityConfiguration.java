package com.example.demo.security;

import com.example.demo.ROLES;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

//@Configuration -- DISABLE EDILDI BEAN LER OLUSTURULMAYACAK
public class BasicSecurityConfiguration {

    @Bean
    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->{
            auth.anyRequest().authenticated();
        });

//        http.formLogin();

        http.sessionManagement(sess ->{
            sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        http.httpBasic();

        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        var admin = User.builder()
                .username("mahmut")
                //.password("{noop}Mahmut20012")
                .password("Mahmut20012")
                .passwordEncoder(e-> passwordEncoder().encode(e))
                .roles(ROLES.ADMIN.name())
                .build();

        var slave = User.builder()
                .username("ela")
                //.password("{noop}Ela2013")
                .password("Ela2013")
                .passwordEncoder(e-> passwordEncoder().encode(e))
                .roles(ROLES.SLAVE.name())
                .build();

        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(slave);
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
