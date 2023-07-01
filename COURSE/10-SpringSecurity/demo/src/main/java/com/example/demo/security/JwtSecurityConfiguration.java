package com.example.demo.security;

import com.example.demo.ROLES;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Configuration
public class JwtSecurityConfiguration {

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

        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt); //jwt enable etmek için -> OAuth2 resource server a token yollandı ama decode edemiyor


        return http.build();
    }

    //1- key pair oluşturulması - Public ve private key ler oluşturuldu
    @Bean
    public KeyPair keyPair(){
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        keyPairGenerator.initialize(2048); //2048 byte lık RSA algorithm
        return keyPairGenerator.generateKeyPair();
    }

    //2- Key pair kullanılarak RSA key object oluşturulmalı - com.nimbusds.jose.jwk.RSAkey kullanılacak
    @Bean
    public RSAKey rsaKey(KeyPair keyPair){
        return new com.nimbusds.jose.jwk.RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    //3- JWKSource oluşturulmalı
    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey){
        var jwkSet = new JWKSet(rsaKey);

        return ((jwkSelector, securityContext) -> jwkSelector.select(jwkSet));
    }

    //4- Decoder oluşturulmalı
    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey){
        try {
            return NimbusJwtDecoder
                    .withPublicKey(rsaKey.toRSAPublicKey())
                    .build();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    // Öncelikle JWT oluşturmak için encoder gerekli
    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource){
        return new NimbusJwtEncoder(jwkSource);
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
