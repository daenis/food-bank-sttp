package com.opendatadelaware.feede.error;

import com.opendatadelaware.feede.config.jwt.JwtToken;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by denniskalaygian on 7/5/17.
 */
public class JwtExpiredTokenException extends AuthenticationException {

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

}
