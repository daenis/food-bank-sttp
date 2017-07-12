package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.config.jwt.token.JwtAuthenticationToken;
import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.service.EntityWrapper;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by denniskalaygian on 7/5/17.
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtSettings jwtSettings;
    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings theJwtSettings,
                                     TokenService theTokenService,
                                     UserService theUserService) {
        jwtSettings = theJwtSettings;
        tokenService = theTokenService;
        userService = theUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authentication.getCredentials();
        Claims claims = jwtToken.getTokenClaims();
        String email = claims.getSubject();
        String jti = claims.getId();
        List<GrantedAuthority> authorities = jwtToken.getAuthorities();
        EntityWrapper<Users> user = userService.getUserFromEmail(email);
        EntityWrapper<Tokens> token = tokenService.getTokenEntityFromJtiToken(jti);
        if (!tokenService.validateUserFromToken(token, user)) {
            throw new BadCredentialsException("The user credentials you provide are incorrect");
        }
        return new JwtAuthenticationToken(jwtToken, token, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
