package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.error.InvalidTokenException;
import com.opendatadelaware.feede.model.Token;
import com.opendatadelaware.feede.model.Users;
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

  public Token loadTokenForUser(String jtiToken, String username) throws InvalidTokenException {
    final Token token = dao.getTokenFromUUID(jtiToken);
    UsersDao userDao = new UsersDao();
    final Users user = userDao.getUserByUsername(username);
    if(user.getUuid() != token.getUser().getUuid()) {
      throw new  InvalidTokenException("Token not found for user");
    }
    return token;
  }
}
