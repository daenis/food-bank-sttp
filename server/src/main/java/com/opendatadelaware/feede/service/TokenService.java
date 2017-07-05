package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.error.InvalidTokenException;
import com.opendatadelaware.feede.model.Token;
import org.springframework.stereotype.Service;

/**
 * Created by aaronlong on 7/4/17.
 */
@Service
public class TokenService extends AbstractService<TokenDao> {

  public Token loadTokenTableFromJtiToken(String jtiToken) throws InvalidTokenException {
    final Token token = dao.getTokenFromUUID(jtiToken);
    if (token == null) {
      throw new InvalidTokenException();
    }
    return token;
  }
}
