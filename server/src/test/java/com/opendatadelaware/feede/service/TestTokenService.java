package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.model.fields.TokenType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by aaronlong on 7/8/17.
 */
public class TestTokenService {

  private TokenService service;
  private Tokens token;
  private Users user;

  @Before
  public void setUp() {
    service = new TokenService();
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

}
