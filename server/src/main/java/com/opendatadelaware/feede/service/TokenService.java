package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.error.InvalidTokenException;
import com.opendatadelaware.feede.model.Token;
import com.opendatadelaware.feede.model.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
@Service
public class TokenService extends AbstractService<TokenDao> {

  private EntityWrapper<Token> loadTokenTableFromJtiToken(String jtiToken) {
    Optional<Token> token = dao.getTokenEntityFromJTI(jtiToken);
    return token.isPresent() ? EntityWrapper.makeWrapper();
  }

  public boolean validateUserFromToken(String jtiToken, EntityWrapper<Users> user) {

  }
}
