package com.opendatadelaware.feede.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.nio.charset.StandardCharsets;

@Configuration
public class JwtSettings {
    /**
     * {@link JwtToken} will expire after this time.
     */
    private Integer tokenExpirationTime;

    private Integer tokenRefreshTime;

    /**
     * Tokens issuer.
     */
    private String tokenIssuer;
    
    /**
     * Key is used to sign {@link JwtToken}.
     */
    private byte[] tokenSigningKey;
    
    /**
     * {@link JwtToken} can be refreshed during this timeframe.
     */

    private Environment environment;

    @Autowired
    public JwtSettings(Environment anEnvironment) {
        environment = anEnvironment;
        tokenIssuer = environment.getProperty("JWT_ISSUER");
        tokenSigningKey = environment.getProperty("JWT_SIGNING_KEY").getBytes(StandardCharsets.UTF_8);
        tokenExpirationTime = Integer.parseInt(environment.getProperty("JWT_EXPIRATION_TIME"));
        tokenRefreshTime = Integer.parseInt(environment.getProperty("JWT_REFRESH_TIME"));
    }

    public JwtSettings setEnvironment(Environment anEnvironment) {
        environment = anEnvironment;
        return this;
    }
    
    public Integer getTokenRefreshTime() {
        return tokenRefreshTime;
    }

    public JwtSettings setTokenRefreshTime(Integer tokenRefreshTime) {
        this.tokenRefreshTime = tokenRefreshTime;
        return this;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }
    
    public JwtSettings setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
        return this;
    }
    
    public String getTokenIssuer() {
        return tokenIssuer;
    }

    public JwtSettings setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
        return this;
    }
    
    public byte[] getTokenSigningKey() {
        return tokenSigningKey;
    }
    
    public JwtSettings setTokenSigningKey(byte[] tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
        return this;
    }
}
