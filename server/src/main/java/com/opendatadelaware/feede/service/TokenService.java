package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.config.jwt.JwtToken;
import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
@Service
public class TokenService extends AbstractService<TokenDao> {

  public EntityWrapper<Tokens> getTokenEntityFromJtiToken(String jtiToken) {
    Optional<Tokens> token = dao.getTokenEntityFromJTI(jtiToken);
    return EntityWrapper.makeWrapper(token);
  }

  public boolean validateUserFromToken(EntityWrapper<Tokens> token, EntityWrapper<Users> user) {
    return token.getEntityObject().getUser().getUuid() == user.getEntityObject().getUuid();
  }

  public JwtToken createToken() {
    return JwtToken.createTokenInstance("");
  }
}
