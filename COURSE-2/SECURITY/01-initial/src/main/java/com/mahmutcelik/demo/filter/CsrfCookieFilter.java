package com.mahmutcelik.demo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CsrfCookieFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName()); //Requestteki CsrfToken okunuyor
        if(csrfToken.getHeaderName() != null){
            response.setHeader(csrfToken.getHeaderName(),csrfToken.getToken()); //UI a response gittiğinde header içerisinde csrf token da olacak - Csrf Cookie oluşturulup UI a gönderilme kısmını da spring security otomatik olarak yapıyor
        }
        filterChain.doFilter(request,response);

    }
}
