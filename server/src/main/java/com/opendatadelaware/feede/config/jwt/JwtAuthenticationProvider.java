package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.model.Tokens;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by denniskalaygian on 7/5/17.
 */
@Component
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
        Claims claims = jwtToken.getTokenClaims();
        List<String> scopes = claims.get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
        // TODO: Just Do It
        return new JwtAuthenticationToken(jwtToken, new Tokens(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
