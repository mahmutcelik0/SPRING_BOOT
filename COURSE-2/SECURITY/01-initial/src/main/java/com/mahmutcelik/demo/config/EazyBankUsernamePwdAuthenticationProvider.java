package com.mahmutcelik.demo.config;

import com.mahmutcelik.demo.model.Customer;
import com.mahmutcelik.demo.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public EazyBankUsernamePwdAuthenticationProvider(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        List<Customer> customerList = customerRepository.findByEmail(authentication.getName());

        if(customerList.isEmpty()){
            throw new BadCredentialsException("EXCEPTION IN AUTHENTICATION PROVIDER CAUSED BY USERNAME");
        }

        Customer customer = customerList.get(0);

        boolean matches = passwordEncoder.matches(authentication.getCredentials().toString(),customerList.get(0).getPwd());

        if(!matches){
            throw new UsernameNotFoundException("EXCEPTION IN AUTHENTICATION PROVIDER CAUSED BY PASSWORD");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(customer.getRole()));

        return new UsernamePasswordAuthenticationToken(authentication.getName(),authentication.getCredentials().toString(),authorities); // Authentication dan aldık çünkü kullanıcı girmişti ilk başta db den geleni almadık

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)); //AbstractUserDetailsAuthProvider dan copy
    }
}
