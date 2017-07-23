package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.config.jwt.JwtSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class ControllerTestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerTestUtil.class);
    private static final String MISSING_FILE = "Test setup error! ";

    public static void setJwtSettingsStub(JwtSettings settings, byte[] secret) {
        when(settings.getTokenSigningKey()).thenReturn(secret);
        when(settings.getTokenExpirationTime()).thenReturn(15);
        when(settings.getTokenRefreshTime()).thenReturn(60);
        when(settings.getTokenIssuer()).thenReturn("feede");
    }

    public static Optional<String> jsonFileToBase64String(String fileName) {
        try {
            URL inputFile = TestUserController.class.getResource(fileName);
            byte[] jsonData = Files.readAllBytes(Paths.get(inputFile.toURI()));
            return Optional.<String>of(Base64.getEncoder().encodeToString(jsonData));
        } catch (Exception e) {
            LOGGER.error(MISSING_FILE + e.getMessage());
            return Optional.empty();
        }
    }
}
