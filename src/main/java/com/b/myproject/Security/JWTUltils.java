package com.b.myproject.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@NoArgsConstructor
public class JWTUltils {
    static final String HEADER_STRING = "Authorization";
    static final String TOKEN_PREFIX = "bMaster ";
    private static final String SECRET = "abcd1234";
    private static final long EXPIRATION_TIME = 864_000_000L;

    String generateToken(String subject) {
        ZonedDateTime expirationTime = ZonedDateTime.now(ZoneOffset.UTC).plus(EXPIRATION_TIME, ChronoUnit.MILLIS);
        return Jwts.builder().setExpiration(Date.from(expirationTime.toInstant()))
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }
}
