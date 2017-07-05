package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.error.JwtExpiredTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import java.util.Date;

/**
 * Created by denniskalaygian on 7/5/17.
 */
public class AuthenticationExceptionConsumer {

    private AuthenticationExceptionConsumer(BadCredentialsException e) {
    }

    private AuthenticationExceptionConsumer(JwtExpiredTokenException e) {
    }

    private AuthenticationExceptionConsumer(AuthenticationException e) {
    }

    public static AuthenticationExceptionConsumer factory(AuthenticationException e) {
        if (e instanceof BadCredentialsException) {
            return new AuthenticationExceptionConsumer((BadCredentialsException) e);
        }
        else if (e instanceof JwtExpiredTokenException) {
            return new AuthenticationExceptionConsumer((JwtExpiredTokenException) e);
        }
        else return new AuthenticationExceptionConsumer(e);
    }
}
