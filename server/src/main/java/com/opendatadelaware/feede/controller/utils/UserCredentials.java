package com.opendatadelaware.feede.controller.utils;

/**
 * Created by aaronlong on 7/11/17.
 */
public class UserCredentials {
  private transient String username;

  private transient String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
