package com.opendatadelaware.feede.config.jwt.token;

import com.opendatadelaware.feede.exception.InvalidTokenException;
import com.opendatadelaware.feede.exception.JwtExpiredTokenException;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.service.EntityWrapper;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UsersService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;


/**
 * Created by aaronlong on 7/7/17.
 */
public class JwtToken {
  private static Logger LOGGER = LoggerFactory.getLogger(JwtToken.class);
  private static String HEADER_PREFIX = "Bearer ";
  private final String tokenAsString;
  private final byte[] tokenSigningKey;
  private Claims claims;

  private JwtToken(String token, byte[] signingKey) {
    tokenAsString = token;
    tokenSigningKey = signingKey;
    getTokenClaims();
  }

  private JwtToken(EntityWrapper<Tokens> token, byte[] signingKey) {
    if (token.isPopulated()) {
      tokenSigningKey = signingKey;
      tokenAsString = buildToken(token.getEntityObject());
    } else throw new InvalidTokenException();
  }

  public static JwtToken createTokenInstance(EntityWrapper<Tokens> token, byte[] signingKey) {
    return new JwtToken(token, signingKey);
  }

  public static JwtToken createTokenInstance(String token, byte[] signingKey) {
    return new JwtToken(token, signingKey);
  }

  public static JwtToken createTokenInstanceFromHeader(String header, byte[] signingKey) {
    if (header == null && header.isEmpty()) {
      throw new AuthenticationServiceException("Authorization Header cannot be blank!");
    }

    if (header.length() < HEADER_PREFIX.length()) {
      throw new AuthenticationServiceException("Invalid authorization header size.");
    }
    String token = header.substring(HEADER_PREFIX.length(), header.length());
    return new JwtToken(token, signingKey);
  }

  private String buildToken(Tokens token) {
    return Jwts.builder().setId(token.getToken().toString())
                          .setExpiration(token.getExpirationTime())
                          .setIssuedAt(token.getCreationTime())
                         .setSubject(token.getUser().getEmail())
            .signWith(SignatureAlgorithm.HS512, tokenSigningKey).compact();
  }

  private Claims parseClaims() {
    try {
      return Jwts.parser().setSigningKey(tokenSigningKey).parseClaimsJws(tokenAsString).getBody();
    } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
      LOGGER.error("Invalid JWT Tokens", ex);
      throw new BadCredentialsException("Invalid JWT token: ", ex);
    } catch (ExpiredJwtException expiredEx) {
      LOGGER.info("JWT Tokens is expired", expiredEx);
      throw new JwtExpiredTokenException( "JWT Tokens expired");
    }
  }

  public String getTokenString() {
    return tokenAsString;
  }

  public Claims getTokenClaims() {
    if (claims == null) {
      claims = parseClaims();
    }
    return claims;
  }

  public boolean confirmTokenViaEntities(TokenService tokenService, UsersService usersService) {
    EntityWrapper<Tokens> token = tokenService.getTokenEntityFromJtiToken(claims.getId());
    return tokenService.validateUserFromToken(token, usersService.getUserFromEmail(claims.getSubject()));
  }
}
