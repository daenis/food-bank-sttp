package com.opendatadelaware.feede.controller.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by denniskalaygian on 6/30/17.
 */
public class TestUserAuthValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUserAuthValidator.class);

    UserAuthValidator userAuthValidator;

    @Before
    public void setUp() {
        try {
            URL inputFile = TestUserAuthValidator.class.getResource("/json/BadUserInput.json");
            byte[] jsonData = Files.readAllBytes(Paths.get(inputFile.toURI()));
            ObjectMapper objectMapper = new ObjectMapper();
            userAuthValidator = objectMapper.readValue(jsonData, UserAuthValidator.class);
        } catch (URISyntaxException | IOException e) {
            LOGGER.error(e.getMessage());
            userAuthValidator = null;
        }
    }

    @Test
    public void testUserAuthValidator() {
        // Then
        Assert.assertTrue("Testing to see if object is Null", userAuthValidator == null);
    }
}
