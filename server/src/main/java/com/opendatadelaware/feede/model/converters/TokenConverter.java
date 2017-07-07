package com.opendatadelaware.feede.model.converters;

import com.opendatadelaware.feede.model.fields.TokenType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
@Converter
public class TokenConverter implements AttributeConverter<TokenType, String> {
  @Override
  public String convertToDatabaseColumn(TokenType token) {
    if (token == null) {
      return null;
    }
    return token.getCode();
  }

  @Override
  public TokenType convertToEntityAttribute(String tokenString) {
    if (tokenString == null) {
      return null;
    }
    Optional<TokenType> field = TokenType.getTypeFromCode(tokenString);
    return field.isPresent() ? field.get() : null;
  }
}
