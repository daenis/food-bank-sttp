package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.controller.TestUserController;
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
  private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);

  private UsersService service;

  @BeforeClass
  public static void init() {
    try {
      Path path = Paths.get(TestUsersService.class.getResource("/base64/good.base64").toURI());
      goodBase64 = Files.readAllBytes(path);
    } catch (URISyntaxException | IOException e) {
      LOGGER.error(e.getMessage());
    }
  }

  @Before
  public void setUp() {
    service = new UsersService();
  }

  @Test
  public void testCreateUserFromRequest() {
    byte[] json = Base64.getDecoder().decode(goodBase64);
    RequestBodyMapper<UserAuthValidator> auth = RequestBodyMapper.factory(json, UserAuthValidator.class);
    Response response = service.createUserFromRequest(auth);
    Assert.assertTrue("Right response is returned", response instanceof Success);
  }

}
