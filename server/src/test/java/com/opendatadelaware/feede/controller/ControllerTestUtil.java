package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.config.jwt.JwtSettings;

import static org.mockito.Mockito.when;

public class ControllerTestUtil {

    public static void setJwtSettingsStub(JwtSettings settings, byte[] secret) {
        when(settings.getTokenSigningKey()).thenReturn(secret);
        when(settings.getTokenExpirationTime()).thenReturn(15);
        when(settings.getTokenRefreshTime()).thenReturn(60);
        when(settings.getTokenIssuer()).thenReturn("feede");
    }
}
