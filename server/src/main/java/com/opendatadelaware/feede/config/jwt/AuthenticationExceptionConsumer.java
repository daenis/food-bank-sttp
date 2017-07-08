package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.exception.JwtExpiredTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by denniskalaygian on 7/5/17.
 */
public class AuthenticationExceptionConsumer {

    private String message;
    private ErrorCodes code;
    private static final HttpStatus status = HttpStatus.UNAUTHORIZED;

    private enum ErrorCodes {
        TOKEN_EXPIRED("Token has expired"),
        BAD_CREDENTIALS("Invalid username or password"),
        AUTHENTICATION("Authorization couldn't be provide");

        private String error;

        ErrorCodes(String theError) {
            error = theError;
        }

        public String getError() {
            return this.error;
        }
    }

    private AuthenticationExceptionConsumer(BadCredentialsException e) {
        setExceptionMessage(e);
        code = ErrorCodes.BAD_CREDENTIALS;

    }

    private AuthenticationExceptionConsumer(JwtExpiredTokenException e) {
        setExceptionMessage(e);
        code = ErrorCodes.TOKEN_EXPIRED;
    }

    private AuthenticationExceptionConsumer(AuthenticationException e) {
        setExceptionMessage(e);
        code = ErrorCodes.AUTHENTICATION;
    }

    private void setExceptionMessage(Exception e) {
        message = e.getMessage();
    }

    private class ErrorResponse implements Serializable {
        private final HttpStatus status;
        private final String message;
        private final String errorCode;
        private final Date timestamp;

        public ErrorResponse() {
            status = AuthenticationExceptionConsumer.status;
            message = AuthenticationExceptionConsumer.this.message;
            errorCode = AuthenticationExceptionConsumer.this.code.getError();
            timestamp = new Date();
        }

        public HttpStatus getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public Date getTimestamp() {
            return timestamp;
        }
    }

    public ErrorResponse getErrorResponse() {
        return new ErrorResponse();
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
