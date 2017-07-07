package com.opendatadelaware.feede.config.jwt.token;

import com.opendatadelaware.feede.exception.JwtExpiredTokenException;
import com.opendatadelaware.feede.model.Token;
import com.opendatadelaware.feede.service.EntityWrapper;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UsersService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaronlong on 7/7/17.
 */
public class JwtToken {
  private static Logger LOGGER = LoggerFactory.getLogger(JwtToken.class);
  private static String HEADER_PREFIX = "Bearer ";
  private final String tokenAsString;
  private final String tokenSigningKey;
  private Claims claims;

  private JwtToken(String token, String signingKey) {
    tokenAsString = token;
    tokenSigningKey = signingKey;
    claims = parseClaims();
  }

  public static JwtToken createTokenInstance(String token, String signingKey) {
    return new JwtToken(token, signingKey);
  }

  public static JwtToken createTokenInstanceFromHeader(String header, String signingKey) {
    if (header == null && header.isEmpty()) {
      throw new AuthenticationServiceException("Authorization Header cannot be blank!");
    }

    if (header.length() < HEADER_PREFIX.length()) {
      throw new AuthenticationServiceException("Invalid authorization header size.");
    }
    String token = header.substring(HEADER_PREFIX.length(), header.length());
    return new JwtToken(token, signingKey);
  }

  private Claims parseClaims() {
    try {
      return Jwts.parser().setSigningKey(tokenSigningKey).parseClaimsJws(tokenAsString).getBody();
    } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
      LOGGER.error("Invalid JWT Token", ex);
      throw new BadCredentialsException("Invalid JWT token: ", ex);
    } catch (ExpiredJwtException expiredEx) {
      LOGGER.info("JWT Token is expired", expiredEx);
      throw new JwtExpiredTokenException( "JWT Token expired");
    }
  }

  public String getTokenString() {
    return tokenAsString;
  }

  public Claims getTokenClaims() {
    return claims;
  }

  public boolean confirmTokenViaEntities(TokenService tokenService, UsersService usersService) {
    EntityWrapper<Token> token = tokenService.getTokenEntityFromJtiToken(claims.getId());
    return tokenService.validateUserFromToken(token, usersService.getUserFromEmail(claims.getSubject()));
  }
}
