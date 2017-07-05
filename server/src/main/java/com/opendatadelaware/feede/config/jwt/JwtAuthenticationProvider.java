package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.error.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by denniskalaygian on 7/5/17.
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtSettings jwtSettings;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authentication.getCredentials();
        Jws<Claims> claims = jwtToken.parseClaims(jwtSettings.getTokenSigningKey());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
