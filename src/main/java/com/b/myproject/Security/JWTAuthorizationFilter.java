package com.b.myproject.Security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.b.myproject.Security.JWTUltils.HEADER_STRING;
import static com.b.myproject.Security.JWTUltils.TOKEN_PREFIX;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private JWTUltils jwtUltils = new JWTUltils();
    private CustomUserDetailsService customUserDetailsService;

    JWTAuthorizationFilter(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService) {
        super(authenticationManager);
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getUsernamePasswordAuth(request));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuth(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING).replace(TOKEN_PREFIX, "");
        String userName = jwtUltils.getUserNameFromToken(token);
        UserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userName);
        return userName != null ? new UsernamePasswordAuthenticationToken(customUserDetails.getUsername(),
                customUserDetails.getPassword(), customUserDetails.getAuthorities()) : null;
    }
}
