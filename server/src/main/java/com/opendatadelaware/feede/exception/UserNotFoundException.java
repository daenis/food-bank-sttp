package com.opendatadelaware.feede.exception;

import java.sql.SQLException;

/**
 * Created by denniskalaygian on 7/6/17.
 */
public class UserNotFoundException extends SQLException {

    private static final String message = "User not found.";

    public UserNotFoundException() {
        super(message);
    }
}
