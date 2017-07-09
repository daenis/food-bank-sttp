package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.service.EntityWrapper;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by denniskalaygian on 7/5/17.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private JwtToken jwtToken;
    private Tokens tokenModel;

    public JwtAuthenticationToken(JwtToken unsafeToken) {
        super(null);
        jwtToken = unsafeToken;
        setAuthenticated(false);
    }

    public JwtAuthenticationToken(JwtToken token,
                                  EntityWrapper<Tokens> tokenModel,
                                  Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        eraseCredentials();
        jwtToken = token;
        this.tokenModel = tokenModel.getEntityObject();
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
    public JwtToken getCredentials() {
        return jwtToken;
    }

    @Override
    public Tokens getPrincipal() {
        return tokenModel;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        jwtToken = null;
    }

}
