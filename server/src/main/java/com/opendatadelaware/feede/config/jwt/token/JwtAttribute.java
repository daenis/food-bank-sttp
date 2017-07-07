package com.opendatadelaware.feede.config.jwt.token;

/**
 * Created by aaronlong on 7/7/17.
 */
public interface JwtAttribute {

  String getAttributeName();

  void setAttributeName(String attribute);

  String getAttributeValue();

  void setAttributeValue(String attributeValue);

}
