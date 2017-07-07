package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.config.jwt.JwtToken;
import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.exception.InvalidTokenException;
import com.opendatadelaware.feede.model.Token;
import com.opendatadelaware.feede.model.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
@Service
public class TokenService extends AbstractService<TokenDao> {

  public EntityWrapper<Token> getTokenEntityFromJtiToken(String jtiToken) {
    Optional<Token> token = dao.getTokenEntityFromJTI(jtiToken);
    return EntityWrapper.makeWrapper(token);
  }

  public boolean validateUserFromToken(EntityWrapper<Token> token, EntityWrapper<Users> user) {
    return token.getEntityObject().getUser().getUuid() == user.getEntityObject().getUuid();
  }

  public JwtToken createToken() {
    return JwtToken.createTokenInstance("");
  }

}
