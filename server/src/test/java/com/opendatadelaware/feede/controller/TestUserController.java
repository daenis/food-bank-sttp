package com.opendatadelaware.feede.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.config.jwt.JwtSettings;
import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UsersService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;


/**
 * Created by aaronlong on 6/28/17.
 */
@RunWith(SpringRunner.class)
public class TestUserController {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);
  private static final String MISSING_FILE = "Test setup error! ";

  private MockMvc mvc;

  @Mock
  private MockEnvironment environment;

  @MockBean
  private UsersDao userDao;

  @MockBean
  private TokenDao tokenDao;

  @SpyBean
  private UsersService usersService;

  @SpyBean
  private TokenService tokenService;

  @SpyBean
  private BCryptPasswordEncoder passwordEncoder;

  @MockBean
  private JwtSettings settings;

  @InjectMocks
  private UsersController controller;

  @Before
  public void initJwtSetting() {
    when(settings.getTokenSigningKey()).thenReturn("secret".getBytes());
    when(settings.getTokenExpirationTime()).thenReturn(15);
    when(settings.getTokenRefreshTime()).thenReturn(60);
    when(settings.getTokenIssuer()).thenReturn("feede");
  }

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  static Optional<String> jsonFileToBase64String(String fileName) {
    try {
      URL inputFile = TestUserController.class.getResource(fileName);
      byte[] jsonData = Files.readAllBytes(Paths.get(inputFile.toURI()));
      return Optional.<String>of(Base64.getEncoder().encodeToString(jsonData));
    } catch (Exception e) {
      LOGGER.error(MISSING_FILE + e.getMessage());
      return Optional.empty();
    }
  }

  @Test
  // Needs to handle the exception
  public void testPostBadInput() throws Exception {
    Optional<String> badAuth = jsonFileToBase64String("/json/BadUserSignUpInput.json");
    if (badAuth.isPresent()) {
      Map<String, String> badInput = Collections.singletonMap("auth", badAuth.get());
      String badAuthBody = new ObjectMapper().writeValueAsString(badInput);
      this.mvc.perform(post("/api/user")
                               .contentType(MediaType.APPLICATION_JSON).content(badAuthBody))
              .andExpect(status().isBadRequest());
    } else {
      Assert.fail(MISSING_FILE + "testPostBadInput()");
    }
  }

  @Test
  public void testPostValidInput() throws Exception {
      Optional<String> goodAuth = jsonFileToBase64String("/json/GoodUserSignUpInput.json");
      when(userDao.getUserByEmail(anyString())).thenReturn(Optional.empty());
      if (goodAuth.isPresent()) {
        Map<String, String> map = Collections.singletonMap("auth", goodAuth.get());
        String goodAuthJsonBody = new ObjectMapper().writeValueAsString(map);
        this.mvc.perform(post("/api/user")
                                 .contentType(MediaType.APPLICATION_JSON).content(goodAuthJsonBody))
                .andExpect(status().isCreated());
      } else {
        Assert.fail(MISSING_FILE + "testPostValidInput()");
      }
  }

  @Test
  public void testTokenCreation() {
//    Users users
//    when(userDao).thenReturn()
  }
}
