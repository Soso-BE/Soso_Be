package com.example.soso.configuration;

import com.example.soso.jwt.JwtFilter;
import com.example.soso.jwt.TokenProvider;
<<<<<<< HEAD
=======
import com.example.soso.service.UserDetailsServiceImpl;
>>>>>>> 662a55560bc07d664388a66946b308995fba5354
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtSecurityConfiguration
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final String SECRET_KEY;
    private final TokenProvider tokenProvider;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void configure(HttpSecurity httpSecurity) {
        JwtFilter customJwtFilter = new JwtFilter(SECRET_KEY, tokenProvider, userDetailsService);
        httpSecurity.addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 662a55560bc07d664388a66946b308995fba5354