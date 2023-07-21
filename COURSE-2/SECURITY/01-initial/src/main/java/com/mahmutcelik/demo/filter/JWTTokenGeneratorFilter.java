package com.mahmutcelik.demo.filter;

import com.mahmutcelik.demo.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null){
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8)); //String ten secret key i oluşturduk
            String jwt = Jwts.builder()
                    .setIssuer("Eazy Bank") // Company etc.
                    .setSubject("JWT Token")
                    .claim("username",authentication.getName()) //Bilgileri token a ekledik -> password u kesinlikle ekleme
                    .claim("authorities",populateAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date().getTime()+300000000))) //Bu süreyi geçince expire olacak
                    .signWith(key).compact(); //signature kısmını yapıyor
            response.setHeader(SecurityConstants.JWT_HEADER,jwt); //response un header ına jwt setlendi


        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user"); // user path i olduğunda false dönecek ve filtreme gerekli olacak yani user path inde filtre çalışır diğerlerinde çalışmaz
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
        StringBuilder returnValue = new StringBuilder();
        authorities.forEach(e -> returnValue.append(e.getAuthority()));
        return returnValue.toString();
    }
}
