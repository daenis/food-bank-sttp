package com.opendatadelaware.feede.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
public enum TokenType {
  USER("USER");

  private String code;

  TokenType(String tokenCode) {
    code = tokenCode;
  }

  public String getCode() {
    return code;
  }

  public static Optional<TokenType> getTypeFromCode(String code) {
    return Arrays.stream(TokenType.values())
                   .filter(t -> t.getCode().equals(code))
                   .findFirst();
  }
}
