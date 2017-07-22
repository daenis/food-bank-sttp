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

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class TestAuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAuthenticationController.class);

    private MockMvc mvc;
    private byte[] secret;

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
    private AuthenticationController controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        secret = "65455ecrvrdytfyg6rr".getBytes();
        when(settings.getTokenSigningKey()).thenReturn(secret);
        when(settings.getTokenExpirationTime()).thenReturn(15);
        when(settings.getTokenRefreshTime()).thenReturn(60);
        when(settings.getTokenIssuer()).thenReturn("feede");
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

//	@Before
//	public void initJwtSetting() {
//		when(settings.getTokenSigningKey()).thenReturn(secret);
//		when(settings.getTokenExpirationTime()).thenReturn(15);
//		when(settings.getTokenRefreshTime()).thenReturn(60);
//		when(settings.getTokenIssuer()).thenReturn("feede");
//		System.out.println("hey");
//		LOGGER.warn(settings.toString());
//	}

    @Test
    public void testTokenCreation() throws Exception {
        String passWordRaw = "12345Password";
        String passWordEncode = passwordEncoder.encode(passWordRaw);
        String email = "johnDoe@gmail.com";
        byte[] authenticationRawBytes = String.format("%s;%s", email, passWordRaw).getBytes();
        String base64Authentication = Base64.getEncoder().encodeToString(authenticationRawBytes);
        Map<String, String> map = Collections.singletonMap("auth", base64Authentication);
        String httpBody = new ObjectMapper().writeValueAsString(map);

        Users user = new Users().setPassword(passWordEncode).setEmail(email).setUuid(UUID.randomUUID());
        Date now = new Date();
        Tokens token = new Tokens().setExpirationTime(new Date(now.getTime() + 900000)).setCreationTime(now)
                .setTokenType(TokenType.USER).setToken(UUID.randomUUID()).setUser(user).setUuid(UUID.randomUUID());
        when(userDao.getUserByEmail(anyString())).thenReturn(Optional.of(user));
        when(tokenDao.createTokenEntry(anyObject())).thenReturn(Optional.of(token));

        MvcResult result = this.mvc
                .perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(httpBody))
                .andExpect(status().isOk()).andReturn();
        EntityWrapper<Tokens> tokensEntityWrapper = EntityWrapper.makeWrapper(Optional.of(token));
        String tokenHeaderExpected = String.format("Bearer %s",
                JwtToken.createTokenInstance(tokensEntityWrapper, secret).getTokenString());
        String tokenHeaderActual = result.getResponse().getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM);
        Assert.assertEquals("Confirming jwt comparisons", tokenHeaderActual, tokenHeaderExpected);
    }

}
