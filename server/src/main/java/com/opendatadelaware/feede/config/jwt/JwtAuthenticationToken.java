package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.model.Token;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by denniskalaygian on 7/5/17.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private JwtToken jwtToken;

    public JwtAuthenticationToken(JwtToken unsafeToken) {
        super(null);
        jwtToken = unsafeToken;
        setAuthenticated(false);
    }

    public JwtAuthenticationToken(JwtToken token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        eraseCredentials();
        jwtToken = token;
        super.setAuthenticated(true);
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return jwtToken;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        jwtToken = null;
    }

}
