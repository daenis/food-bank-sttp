package com.opendatadelaware.feede.controller.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Created by denniskalaygian on 6/30/17.
 */
public class TestUserAuthValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUserAuthValidator.class);

    private static void testErrorLogger() {
        LOGGER.error("The test was setup improperly");
    }

    public Optional<UserAuthValidator> configure(String fileNameAndPath) {
        try {
            URL inputFile = TestUserAuthValidator.class.getResource(fileNameAndPath);
            byte[] jsonData = Files.readAllBytes(Paths.get(inputFile.toURI()));
            ObjectMapper objectMapper = new ObjectMapper();
            return Optional.of(objectMapper.readValue(jsonData, UserAuthValidator.class));
        } catch (URISyntaxException | IOException e) {
            LOGGER.error(e.getMessage());
            return Optional.empty();
        }
    }

    @Test
    public void testUserAuthValidatorInvalid() {
        Optional<UserAuthValidator> userAuthValidator = configure("/json/BadUserInput.json");
        if (userAuthValidator.isPresent()) {
            // Then
            Assert.assertFalse("Testing to see if object is invalid", userAuthValidator.get().isValid());
        } else testErrorLogger();
    }

    @Test
    public void testUserAuthValidatorValid() {
        Optional<UserAuthValidator> userAuthValidator = configure("/json/GoodUserInput.json");
        if (userAuthValidator.isPresent()) {
            Assert.assertTrue("Testing to see if object is valid", userAuthValidator.get().isValid());
        } else testErrorLogger();
    }

    @Test
    public void testIsValidInvalid() {
        UserAuthValidator user = new UserAuthValidator(null, "Doe", "johnDoe",
                                                       "12345", "3023333333",
                                                       "111 This Street","Milford", "DE",
                                                       "19963", "Farm");

        Assert.assertTrue("Checking to see if the isValid function responds correctly",
                          user.isValid() == false);
    }

    /*@Test
    public void testInvalidPhoneNumber() {
        UserAuthValidator user = new UserAuthValidator("John", "Doe", "johnDoe",
                                                       "12345", "(302)--333-3333",
                                                       "111 This Street","Milford", "DE",
                                                       "19963", "Farm");
        Assert.assertFalse("Checking to see if the phone number is ruled invalid", user.isValid());
    }

    @Test
    public void testValidPhoneNumber() {
        UserAuthValidator user = new UserAuthValidator(null, "Doe", "johnDoe",
                "12345", "(302)--333-3333",
                "111 This Street","Milford", "DE",
                "19963", "Farm");
        Assert.assertTrue("Checking to see if the phone number is ruled as valid", user.isValid());
    }*/
}
