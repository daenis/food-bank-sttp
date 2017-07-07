package com.opendatadelaware.feede.config.jwt.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;
import java.util.Date;

/**
 * Created by denniskalaygian on 7/7/17.
 */
public class TestJwtToken {

    private Key key;
    private String jwt;
    private static final String BEARER = "Bearer ";

    @Before
    public void setup() {
        key = MacProvider.generateKey();
        jwt = Jwts.builder().setSubject("johndoe@example.net").
                setIssuer("tariq").setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 90000))
                .setAudience("Froilan").setId("re4378t476590876").signWith(SignatureAlgorithm.HS512, key).compact();
    }

    @Test
    public void testCreateTokenInstanceFromHeader() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        String tokenString = token.getTokenString();
        Assert.assertEquals("Assert that 'Bearer' was stripped from header correctly", jwt, tokenString);
    }

    @Test
    public void testGetTokenClaimsSubject() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Claims claims = token.getTokenClaims();
        String prediction = "johndoe@example.net";
        String result = claims.getSubject();
        Assert.assertEquals("Assert that token subject is generated correctly", prediction, result);
    }

    @Test
    public void testGetTokenClaimsIssuer() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Claims claims = token.getTokenClaims();
        String prediction = "tariq";
        String result = claims.getIssuer();
        Assert.assertEquals("Assert that token issuer is generated correctly", prediction, result);
    }

    @Test
    public void testGetTokenClaimsIssuedAt() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Claims claims = token.getTokenClaims();
        Date result = claims.getIssuedAt();
        Assert.assertTrue("Assert that token issue date is generated", result != null);
    }

    @Test
    public void testGetTokenClaimsExpiration() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Claims claims = token.getTokenClaims();
        Long currentTime = claims.getIssuedAt().getTime();
        Long expirationTime = claims.getExpiration().getTime();
        Assert.assertTrue("Assert that token expire date is generated", currentTime < expirationTime);
    }

    @Test
    public void testGetTokenClaimsAudience() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Claims claims = token.getTokenClaims();
        String prediction = "Froilan";
        String result = claims.getAudience();
        Assert.assertEquals("Assert that token audience is generated correctly", prediction, result);
    }

    @Test
    public void testGetTokenClaimsId() {
        String header = BEARER + jwt;
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Claims claims = token.getTokenClaims();
        String prediction = "re4378t476590876";
        String result = claims.getId();
        Assert.assertEquals("Assert that token Id is generated correctly", prediction, result);
    }

}
