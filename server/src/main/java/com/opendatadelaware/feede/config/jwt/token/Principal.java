package com.opendatadelaware.feede.config.jwt.token;

/**
 * Created by aaronlong on 7/7/17.
 */
public class Principal implements JwtAttribute {
  private final String attributeName;
  private final String attributeValue;

  public Principal(String name, String value) {
      attributeName = name;
      attributeValue = value;
  }

  @Override
  public String getAttributeType() {
    return JwtAttribute.PRINCIPAL;
  }

  @Override
  public String getAttributeName() {
    return attributeName;
  }

  @Override
  public String getAttributeValue() {
    return attributeValue;
  }

}
