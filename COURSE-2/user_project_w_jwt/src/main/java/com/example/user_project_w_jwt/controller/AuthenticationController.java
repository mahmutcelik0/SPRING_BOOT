package com.example.user_project_w_jwt.controller;

import com.example.user_project_w_jwt.dto.AuthenticationDto;
import com.example.user_project_w_jwt.dto.AuthenticationResponse;
import com.example.user_project_w_jwt.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthenticationController(AuthService authService, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationDto authenticationDto, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDto.getEmail(),authenticationDto.getPassword()));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Incorrect credentials");
        }catch (DisabledException e){
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE,"User is not activated");
            return null;
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("Username is not correct");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getEmail());

        String jwt = //generates jwt token as string

        return new AuthenticationResponse();

    }
}
