package com.opendatadelaware.feede.error;

import java.io.IOException;


/**
 * Created by aaronlong on 7/5/17.
 */
public class InvalidTokenException extends IOException {
  final static String message = "Your token has expired or been corrupted";
  public InvalidTokenException() {
    super(message);
  }

  public InvalidTokenException(String message) {
    super(message);
  }
}
