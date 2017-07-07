package com.opendatadelaware.feede.config.jwt.token;

/**
 * Created by aaronlong on 7/7/17.
 */
public interface JwtAttribute {
  String CLAIM = "CLAIM";
  String PRINCIPAL = "PRINCIPAL";

  String getAttributeType();

  String getAttributeName();

  void setAttributeName(String attribute);

  String getAttributeValue();

  void setAttributeValue(String value);

}
