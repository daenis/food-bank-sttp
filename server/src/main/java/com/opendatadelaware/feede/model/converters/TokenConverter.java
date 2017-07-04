package com.opendatadelaware.feede.model.converters;

import com.opendatadelaware.feede.model.Token;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by aaronlong on 7/4/17.
 */
@Converter
public class TokenConverter implements AttributeConverter<Token, String> {
  @Override
  public String convertToDatabaseColumn(Token token) {
    return null;
  }

  @Override
  public Token convertToEntityAttribute(String s) {
    return null;
  }
}
