package com.opendatadelaware.feede.config.jwt.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;

import java.security.Key;

/**
 * Created by denniskalaygian on 7/7/17.
 */
public class TestJwtToken {

    @Test
    public void testCreateTokenInstanceFromHeader() {
        Key key = MacProvider.generateKey();
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS512, key).compact();
        String header = String.format("Bearer %s", jwt);
    }
}
