package com.opendatadelaware.feede.config.jwt.token;

import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.model.fields.TokenType;
import com.opendatadelaware.feede.service.EntityWrapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by denniskalaygian on 7/7/17.
 */
public class TestJwtToken {

    private Key key;
    private String jwt;
    private Claims claims;
    private static final String BEARER = "Bearer ";

    @Before
    public void setup() {
        key = MacProvider.generateKey();
        jwt = Jwts.builder().setSubject("johndoe@example.net").
                setIssuer("tariq").setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 90000))
                .setAudience("Froilan").setId("re4378t476590876").signWith(SignatureAlgorithm.HS512, key).compact();
    }

    @Before
    public void setUpForTokenGeneration() {
        Users user = new Users().setEmail("johndoe@example.com").setPassword("12345").setLocation("19963")
                             .setPhone("3022222222").setType("user");

        Date issuedTime = new Date();

        Date expirationTime = new Date(issuedTime.getTime() + 90000);

        Tokens predictionToken = new Tokens().setCreationTime(issuedTime)
                                        .setExpirationTime(expirationTime).setTokenType(TokenType.USER)
                                        .setActive(true).setUser(user).setToken(UUID.randomUUID());

        EntityWrapper<Tokens> wrapper = EntityWrapper.makeWrapper(Optional.of(predictionToken));

        String result = JwtToken.createJwtToken(wrapper, key.getEncoded()).getTokenString();

        claims = Jwts.parser().setSigningKey(key).parseClaimsJws(result).getBody();
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

    @Test
    public void testBuildTokenSubject() {
        Assert.assertEquals("Checking built token's subject",
                "johndoe@example.com", claims.getSubject());
    }

    @Test
    public void testBuildTokenJTI() {
        Assert.assertTrue("Checking built token's jti",
                claims.getId() != null);
    }

    @Test
    public void testBuildTokenIssueTime() {
        Assert.assertTrue("Checking built token's expiration",
                claims.getExpiration().getTime() > new Date().getTime());
    }


}
