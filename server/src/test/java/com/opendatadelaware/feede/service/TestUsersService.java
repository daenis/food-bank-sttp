package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.controller.TestUserController;
import com.opendatadelaware.feede.controller.responses.BadRequest;
import com.opendatadelaware.feede.controller.responses.Response;
import com.opendatadelaware.feede.controller.responses.Success;
import com.opendatadelaware.feede.controller.utils.RequestBodyMapper;
import com.opendatadelaware.feede.controller.utils.UserAuthValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created by aaronlong on 7/8/17.
 */
public class TestUsersService {

  private static byte[] goodBase64;
  private static byte[] badBase64;
  private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);

  private UsersService service;

  @BeforeClass
  public static void init() {
    goodBase64 = readFile("/base64/good.base64");
    badBase64  = readFile("/base64/bad.base64");
  }

  private static byte[] readFile(String fileName) {
    try {
      Path path = Paths.get(TestUsersService.class.getResource(fileName).toURI());
      return Files.readAllBytes(path);
    } catch (URISyntaxException | IOException e) {
      LOGGER.error(e.getMessage());
      return null;
    }
  }

  @Before
  public void setUp() {
    service = new UsersService();
  }

  @Test
  public void testCreateUserFromRequestSuccess() {
    byte[] json = Base64.getDecoder().decode(goodBase64);
    RequestBodyMapper<UserAuthValidator> auth = RequestBodyMapper.factory(json, UserAuthValidator.class);
    Response response = service.createUserFromRequest(auth);
    Assert.assertTrue("Success response is returned", response instanceof Success);
  }

  @Test
  public void testCreateUserFromRequestBadRequest() {
    byte[] json = Base64.getDecoder().decode(badBase64);
    RequestBodyMapper<UserAuthValidator> auth = RequestBodyMapper.factory(json, UserAuthValidator.class);
    Response response = service.createUserFromRequest(auth);
    Assert.assertTrue("BadRequest response is returned", response instanceof BadRequest);
  }

}
