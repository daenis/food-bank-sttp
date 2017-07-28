package com.opendatadelaware.feede.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.config.jwt.JwtSettings;
import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.dao.UserDao;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * Created by aaronlong on 6/28/17.
 */
public class TestUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);

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
}
