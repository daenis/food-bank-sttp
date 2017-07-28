package com.opendatadelaware.feede.model.fields;

import java.util.EnumSet;
import java.util.Optional;

/**
 * Created by aaronlong on 7/4/17.
 */
public enum TokenType {
    USER("USER");

    private String code;

    TokenType(String tokenCode) {
        code = tokenCode;
    }

    public static Optional<TokenType> getTypeFromCode(String code) {
        return EnumSet.allOf(TokenType.class)
                .stream()
                .filter(t -> t.getCode().equals(code))
                .findFirst();
    }

    public String getCode() {
        return code;
    }
}
