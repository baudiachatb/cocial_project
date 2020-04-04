package com.b.myproject.Security;

import com.b.myproject.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.b.myproject.common.MessageError.LOI_XAC_THUC_USERNAME_PASSWORD;

@NoArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private JWTUltils jwtUltils = new JWTUltils();
    private AuthenticationManager authenticationManager;
    @Autowired
    SessionRegistry sessionRegistry;
            JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserEntity userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));
        } catch (Exception e) {
            e.fillInStackTrace();
            throw new RuntimeException(LOI_XAC_THUC_USERNAME_PASSWORD);
        }
    }
    @Override
    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/v1/user/login"));
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWTUltils.TOKEN_PREFIX + jwtUltils.generateToken(((CustomUserDetails) authResult.getPrincipal()).getUsername());
        response.getWriter().write(token);
        response.addHeader(JWTUltils.HEADER_STRING, token);
    }
}
