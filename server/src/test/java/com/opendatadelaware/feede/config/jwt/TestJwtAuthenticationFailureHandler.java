package com.opendatadelaware.feede.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static org.hamcrest.core.StringContains.containsString;


/**
 * Created by aaronlong on 7/8/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestJwtAuthenticationFailureHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestJwtAuthenticationFailureHandler.class);
  private ObjectMapper mapper;
  private AuthenticationFailureHandler failureHandler;

  @Mock
  private HttpServletRequest request;
  @Mock
  private HttpServletResponse response;
  private PrintWriter writer;
  private ByteArrayOutputStream stream;
  private AuthenticationException exception;
  private AuthenticationExceptionConsumer.ErrorResponse errorResponseExpected;

  @Before
  public void setUp() {
    try {
      mapper = new ObjectMapper();
      failureHandler = new JwtAuthenticationFailureHandler(mapper);
      stream = new ByteArrayOutputStream();
      writer = new PrintWriter(stream);
      when(response.getWriter()).thenReturn(writer);
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
    }
  }

  @After
  public void tearDown() {
    try {
      writer.close();
      stream.close();
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
    }
  }

  @Test
  public void testBadCredentialsHandling() throws IOException, ServletException {
    exception = new BadCredentialsException("Bad Creds");
    errorResponseExpected = AuthenticationExceptionConsumer.factory(exception).getErrorResponse();
    failureHandler.onAuthenticationFailure(request, response, exception);
    String badCredentialsActual = new String(stream.toByteArray());
    Assert.assertThat(badCredentialsActual, containsString(errorResponseExpected.getErrorCode()));
  }
}
