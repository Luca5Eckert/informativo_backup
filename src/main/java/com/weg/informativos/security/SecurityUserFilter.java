package com.weg.informativos.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityUserFilter extends OncePerRequestFilter {

    @Autowired
    private final SecurityUserFilter securityUserFilter;

    public SecurityUserFilter(SecurityUserFilter securityUserFilter) {
        this.securityUserFilter = securityUserFilter;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if(header != null){



        }
    }

}
