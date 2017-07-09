package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UsersService;
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
    private final TokenService tokenService;
    private final UsersService usersService;

    @Autowired
    public JwtAuthenticationProvider(JwtSettings theJwtSettings,
                                     TokenService theTokenService,
                                     UsersService theUsersService) {
        jwtSettings = theJwtSettings;
        tokenService = theTokenService;
        usersService = theUsersService;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authentication.getCredentials();
        List<GrantedAuthority> authorities = jwtToken.getAuthority();
        // TODO: Just Do It
        return new JwtAuthenticationToken(jwtToken, new Tokens(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
