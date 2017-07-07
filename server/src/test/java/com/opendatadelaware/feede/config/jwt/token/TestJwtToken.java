package com.opendatadelaware.feede.config.jwt.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;
import java.util.Date;

/**
 * Created by denniskalaygian on 7/7/17.
 */
public class TestJwtToken {

    @Test
    public void testCreateTokenInstanceFromHeader() {
        Key key = MacProvider.generateKey();
        String jwt = Jwts.builder().setSubject("johndoe@example.net").
        setIssuer("tariq").setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 90000))
                .setAudience("Froilan").setId("re4378t476590876").signWith(SignatureAlgorithm.HS512, key).compact();
        String header = String.format("Bearer %s", jwt);
        System.out.println(key.getEncoded());
        JwtToken token = JwtToken.createTokenInstanceFromHeader(header, key.getEncoded());
        Assert.assertEquals("Assert that 'Bearer' was stripped from header correctly", jwt, token.getTokenString());
    }
}
