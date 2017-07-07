package com.opendatadelaware.feede.exception;

import io.jsonwebtoken.JwtException;


/**
 * Created by aaronlong on 7/5/17.
 */
public class InvalidTokenException extends JwtException {
  final static String message = "Your token has expired or been corrupted";
  public InvalidTokenException() {
    super(message);
  }

  public InvalidTokenException(String message) {
    super(message);
  }
}
