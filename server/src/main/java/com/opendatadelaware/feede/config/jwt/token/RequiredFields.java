package com.opendatadelaware.feede.config.jwt.token;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;

/**
 * Created by denniskalaygian on 7/7/17.
 */
public enum RequiredFields {

    SUBJECT("sub"), ISSUED("iat"), EXPIRATION("exp"),
    ISSUER("iss"), JWT_ID("jti");

    private String fieldName;

    RequiredFields(String field) {
        fieldName = field;
    }

    public String getField() {
        return fieldName;
    }

    public static boolean validateFields(Map<String, JwtAttribute> attr) {
        Optional<RequiredFields> result = EnumSet.allOf(RequiredFields.class)
                .stream()
                .filter(f -> !attr.containsKey(f))
                .findAny();
        return !result.isPresent();
    }
}
