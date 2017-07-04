package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.model.Token;

import java.util.UUID;

/**
 * Created by aaronlong on 7/4/17.
 */
public class TokenDao extends AbstractDao<Token, UUID> {
  public TokenDao() {
    super(Token.class);
  }
}
