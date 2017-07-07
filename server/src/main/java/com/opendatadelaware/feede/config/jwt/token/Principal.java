package com.opendatadelaware.feede.config.jwt.token;

/**
 * Created by aaronlong on 7/7/17.
 */
public class Principal implements JwtAttribute {
  private String attributeName;
  private String attributeValue;

  @Override
  public String getAttributeType() {
    return JwtAttribute.PRINCIPAL;
  }

  @Override
  public String getAttributeName() {
    return attributeName;
  }

  @Override
  public void setAttributeName(String attribute) {
    attributeName = attribute;
  }

  @Override
  public String getAttributeValue() {
    return attributeValue;
  }

  @Override
  public void setAttributeValue(String value) {
    attributeValue = value;
  }
}
