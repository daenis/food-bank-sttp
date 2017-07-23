package com.opendatadelaware.feede.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.config.WebSecurityConfig;
import com.opendatadelaware.feede.config.jwt.JwtSettings;
import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.dao.UserDao;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.model.fields.TokenType;
import com.opendatadelaware.feede.service.EntityWrapper;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UserService;
import org.junit.Assert;
import org.junit.Before;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    private UserDao userDao;

    @MockBean
    private TokenDao tokenDao;

    @SpyBean
    private UserService userService;

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
        ControllerTestUtil.setJwtSettingsStub(settings, "secret".getBytes());
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    // Needs to handle the exception
    public void testPostBadInput() throws Exception {
        Optional<String> badAuth = ControllerTestUtil.jsonFileToBase64String("/json/BadUserSignUpInput.json");
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
        Optional<String> goodAuth = ControllerTestUtil.jsonFileToBase64String("/json/GoodUserSignUpInput.json");
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
}
