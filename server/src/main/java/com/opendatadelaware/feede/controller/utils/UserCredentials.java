package com.opendatadelaware.feede.controller.utils;

import org.bouncycastle.util.encoders.Base64;

import javax.security.auth.login.CredentialException;

/**
 * Created by aaronlong on 7/11/17.
 */
public class UserCredentials {

    private static String errorMessage = "Username or Password are invalid";
    private transient String username;

    private transient String password;

    public UserCredentials(String base64String) throws CredentialException {
        String[] credentials = base64StringToGeneralString(base64String).split(";");
        if (credentials.length > 2 || credentials.length < 2) {
            throw new CredentialException(errorMessage);
        }
        username = credentials[0];
        password = credentials[1];
    }

    private static String base64StringToGeneralString(String base64String) {
        byte[] byteString = Base64.decode(base64String);
        return new String(byteString);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
