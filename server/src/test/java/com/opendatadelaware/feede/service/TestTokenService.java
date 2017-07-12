package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.config.jwt.JwtSettings;
import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.model.fields.TokenType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

/**
 * Created by aaronlong on 7/8/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTokenService {
  @Mock
  private JwtSettings settings;
  @Mock
  private TokenDao dao;

  private final byte[] key = "f46a6223b7ce1f82fbfa251ac054".getBytes();
  private TokenService service;
  private Tokens token;
  private Users user;

  @Before
  public void setUp() {
    when(settings.getTokenSigningKey()).thenReturn(key);
    service = new TokenService(settings);
    service.setDao(dao);
    user = new Users().setEmail("xxx@gmail.com").setUuid(UUID.randomUUID());
    token = new Tokens().setToken(UUID.randomUUID()).setTokenType(TokenType.USER)
            .setActive(true).setUser(user);
  }

  @Test
  public void testValidateUserTokenRelationship() {
    EntityWrapper<Tokens> tokenWrapper = EntityWrapper.makeWrapper(Optional.of(token));
    EntityWrapper<Users> userWrapper = EntityWrapper.makeWrapper(Optional.of(user));
    boolean result = service.validateUserFromToken(tokenWrapper, userWrapper);
    Assert.assertTrue("Assert that user and token are referenced", result);
  }

  @Test
  public void testCreateToken() {
    Users theUser = new Users().setEmail("something@gmail.com")
                            .setPassword("123456").setAddress("811 this street")
                            .setCity("Wilmington").setState("DE")
                            .setZip("19963").setPhone("3022222222").setUuid(UUID.randomUUID());
    EntityWrapper<Users> userWrapper = EntityWrapper.makeWrapper(Optional.of(theUser));

    Date now = new Date();
    Tokens token = new Tokens().setUser(theUser)
                           .setActive(true)
                           .setToken(UUID.randomUUID())
                           .setUuid(UUID.randomUUID())
                           .setTokenType(TokenType.USER)
                           .setCreationTime(now)
                           .setExpirationTime(new Date(now.getTime() + 900000));
    when(dao.createTokenEntry(userWrapper)).thenReturn(Optional.of(token));

    JwtToken result = service.createToken(userWrapper);
    Assert.assertEquals("Checking to see if a token is correctly generated",
            theUser.getEmail(), result.getTokenClaims().getSubject());
  }

}
