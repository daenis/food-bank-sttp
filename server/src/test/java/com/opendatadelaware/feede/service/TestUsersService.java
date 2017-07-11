package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.controller.TestUserController;
import com.opendatadelaware.feede.controller.responses.BadRequest;
import com.opendatadelaware.feede.controller.responses.Response;
import com.opendatadelaware.feede.controller.responses.Success;
import com.opendatadelaware.feede.controller.utils.RequestBodyMapper;
import com.opendatadelaware.feede.controller.utils.UserAuthValidator;
import com.opendatadelaware.feede.controller.utils.UserCredentials;
import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.model.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.auth.login.CredentialException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by aaronlong on 7/8/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUsersService {

  private static byte[] goodNewUserBase64;
  private static byte[] badNewUserBase64;
  private static String goodUserLoginBase64;
  private static String badUserLoginBase64;

  private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);

  @Mock
  private UsersDao dao;

  @Mock
  private PasswordEncoder passwordEncoder;

  private UsersService service;

  @BeforeClass
  public static void init() {
    goodNewUserBase64 = readFile("/base64/goodNewUser.base64");
    badNewUserBase64  = readFile("/base64/badNewUser.base64");
    goodUserLoginBase64 = readFileAsString("/base64/goodUserLogin.base64");
    badUserLoginBase64 = readFileAsString("/base64/badUserLogin.base64");
  }

  private static String readFileAsString(String fileName) {
    try {
      URL url = TestUsersService.class.getResource(fileName);
      byte[] fileAsBytes = Files.readAllBytes(Paths.get(url.toURI()));
      return new String(fileAsBytes);
    } catch(URISyntaxException | IOException e) {
      System.out.println(e.getMessage());
      return "";
    }
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
    service.setDao(dao);
    service.setPasswordEncoder(passwordEncoder);
  }

  @Test
  public void testCreateUserFromRequestSuccess() {
    byte[] json = Base64.getDecoder().decode(goodNewUserBase64);
    RequestBodyMapper<UserAuthValidator> auth = RequestBodyMapper.factory(json, UserAuthValidator.class);
    when(dao.getUserByEmail(anyString())).thenReturn(Optional.empty());
    Response response = service.createUserFromRequest(auth);
    Assert.assertTrue("Success response is returned", response instanceof Success);
  }

  @Test
  public void testCreateUserFromRequestBadRequest() {
    byte[] json = Base64.getDecoder().decode(badNewUserBase64);
    RequestBodyMapper<UserAuthValidator> auth = RequestBodyMapper.factory(json, UserAuthValidator.class);
    Response response = service.createUserFromRequest(auth);
    Assert.assertTrue("BadRequest response is returned", response instanceof BadRequest);
  }
  
  @Test
  public void testValidateUserForLoginSuccess() throws CredentialException {
    UserCredentials creds = new UserCredentials(goodUserLoginBase64);
    EntityWrapper<Users> user = service.validateUserForLogin(creds);
    Assert.assertTrue("Checking to see if a valid user object is returned", user != null);
    // Test to make sure that token is returned for a valid user
  }

  // Test for the exception
  
  @Test
  public void testValidateUserForLoginFailure() {
    
  }

}
