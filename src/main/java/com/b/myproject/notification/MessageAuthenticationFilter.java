package com.b.myproject.notification;

import com.b.myproject.Security.CustomUserDetailsService;
import com.b.myproject.Security.JWTUltils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import static com.b.myproject.Security.JWTUltils.TOKEN_PREFIX;

@Component
public class MessageAuthenticationFilter implements ChannelInterceptor {
    private static final String TOKEN = "token";
    private JWTUltils jwtUltils = new JWTUltils();
    private CustomUserDetailsService customUserDetailsService;
    MessageAuthenticationFilter(CustomUserDetailsService customUserDetailsService){
        this.customUserDetailsService = customUserDetailsService;
    }
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT == accessor.getCommand()) {
            final String token = accessor.getFirstNativeHeader(TOKEN);
            final UsernamePasswordAuthenticationToken user = getUsernamePasswordAuth(token);
            accessor.setUser(user);
        }
        return message;
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuth(String getToken) {
        String token = getToken.replace(TOKEN_PREFIX, "");
        String userName = jwtUltils.getUserNameFromToken(token);
        UserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userName);
        return userName != null ? new UsernamePasswordAuthenticationToken(customUserDetails.getUsername(),
                customUserDetails.getPassword(), customUserDetails.getAuthorities()) : null;
    }
}
