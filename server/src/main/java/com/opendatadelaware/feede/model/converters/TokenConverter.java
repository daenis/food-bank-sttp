package com.opendatadelaware.feede.model.converters;

import com.opendatadelaware.feede.model.fields.TokenField;
import jdk.nashorn.internal.parser.TokenType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
@Converter
public class TokenConverter implements AttributeConverter<TokenField, String> {
  @Override
  public String convertToDatabaseColumn(TokenField token) {
    if (token == null) {
      return null;
    }
    return token.getCode();
  }

  @Override
  public TokenField convertToEntityAttribute(String tokenString) {
    if (tokenString == null) {
      return null;
    }
    Optional<TokenField> field = TokenField.getTypeFromCode(tokenString);
    return field.isPresent() ? field.get() : null;
  }
}
