package com.opendatadelaware.feede.model.fields;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
public enum TokenField {
  USER("USER");

  private String code;

  TokenField(String tokenCode) {
    code = tokenCode;
  }

  public String getCode() {
    return code;
  }

  public static Optional<TokenField> getTypeFromCode(String code) {
    return EnumSet.allOf(TokenField.class)
                   .stream()
                   .filter(t -> t.getCode().equals(code))
                   .findFirst();
  }
}
