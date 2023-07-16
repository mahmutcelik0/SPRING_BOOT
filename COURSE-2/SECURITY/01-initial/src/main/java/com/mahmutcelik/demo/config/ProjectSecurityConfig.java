package com.mahmutcelik.demo.config;

import com.mahmutcelik.demo.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.mapping.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.function.Function;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http
                .securityContext(sc -> sc.requireExplicitSave(false)) //JSESSION ID creation u ve context e save edilmesi spring framework e bırakıldı
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration corsConfiguration = new CorsConfiguration();
                        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); //4200 den gelecek originlere izin verir.
                        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));    //Portlar farklı olduğu için browser daki cors engelliyor ama biz 4200 den geleceklere izin verdik
                        corsConfiguration.setAllowCredentials(true);
                        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                        corsConfiguration.setMaxAge(3600L);
                        return corsConfiguration;
                    }
                }))

//                .csrf(csrf -> csrf.ignoringRequestMatchers("/contact","/register")) //POST PUT DELETE PATCH YAPMAMIZI ENGELLIYORDU DISABLE ETTIK - POST OLDUKLARI İÇİN CSRF TEN GEÇİYORLAR YANİ ÇALIŞIYOR CSRF PROTECTION YAPILMIYOR
                .csrf(csrf -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact", "/register").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // ??
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class) //BasicAuthenticationFilter da kullanıcı login olmuş olur ve sonrasında da CsrfCookieFilter çalıştırılır
                .authorizeHttpRequests(request -> request.requestMatchers("/account/**", "/balance/**", "/loans/**", "/cards/**", "/user/**").authenticated() // bu base deki endpointler authentication gerektiriyor
                        .requestMatchers("/notices", "/contact", "/register").permitAll())    // bu base deki endpointler authentication gerekmiyor
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    //PROJEDE KULLANILACAK PASSWORD ENCODER BEAN INI OLUSTURUR
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
