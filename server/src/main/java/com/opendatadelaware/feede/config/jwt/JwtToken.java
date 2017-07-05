package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.error.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;


/**
 * Created by denniskalaygian on 7/5/17.
 */
public class JwtToken {

    private static Logger LOGGER = LoggerFactory.getLogger(JwtToken.class);
    private static String HEADER_PREFIX = "Bearer ";
    private String token;

    private JwtToken(String token) {
        this.token = token;
    }

    public static JwtToken createTokenInstance(String token) {
        return new JwtToken(token);
    }

    public static JwtToken createTokenInstanceFromHeader(String header) {
        if (header == null && header.isEmpty()) {
            throw new AuthenticationServiceException("Authorization Header cannot be blank!");
        }

        if (header.length() < HEADER_PREFIX.length()) {
            throw new AuthenticationServiceException("Invalid authorization header size.");
        }
        String token = header.substring(HEADER_PREFIX.length(), header.length());
        return new JwtToken(token);
    }

    public Jws<Claims> parseClaims(String signingKey) throws InvalidTokenException {
        try {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            LOGGER.error("Invalid JWT Token", ex);
            throw new BadCredentialsException("Invalid JWT token: ", ex);
        } catch (ExpiredJwtException expiredEx) {
            LOGGER.info("JWT Token is expired", expiredEx);
            throw new InvalidTokenException( "JWT Token expired");
        }
    }



}
