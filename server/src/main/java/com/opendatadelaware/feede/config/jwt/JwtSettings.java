package com.opendatadelaware.feede.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class JwtSettings {
    /**
     * {@link JwtToken} will expire after this time.
     */
    private Integer tokenExpirationTime;

    private Integer tokenRefreshTime;

    /**
     * Token issuer.
     */
    private String tokenIssuer;
    
    /**
     * Key is used to sign {@link JwtToken}.
     */
    private String tokenSigningKey;
    
    /**
     * {@link JwtToken} can be refreshed during this timeframe.
     */

    private Environment environment;

    @Autowired
    public JwtSettings(Environment anEnvironment) {
        environment = anEnvironment;
        tokenIssuer = environment.getProperty("JWT_ISSUER");
        tokenSigningKey = environment.getProperty("JWT_SIGNING_KEY");
        tokenExpirationTime = Integer.parseInt(environment.getProperty("JWT_EXPIRATION_TIME"));
        tokenRefreshTime = Integer.parseInt(environment.getProperty("JWT_REFRESH_TIME"));
    }

    public void setEnvironment(Environment anEnvironment) {
        environment = anEnvironment;
    }
    
    public Integer getTokenRefreshTime() {
        return tokenRefreshTime;
    }

    public void setTokenRefreshTime(Integer tokenRefreshTime) {
        this.tokenRefreshTime = tokenRefreshTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }
    
    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }
    
    public String getTokenIssuer() {
        return tokenIssuer;
    }

    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }
    
    public String getTokenSigningKey() {
        return tokenSigningKey;
    }
    
    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }
}
