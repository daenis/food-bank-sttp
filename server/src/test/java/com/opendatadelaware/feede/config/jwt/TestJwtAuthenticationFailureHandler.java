package com.opendatadelaware.feede.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.exception.JwtExpiredTokenException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;


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

    private void callErrorRequest(AuthenticationException e) throws IOException, ServletException {
        failureHandler.onAuthenticationFailure(request, response, e);
    }

    private void setErrorResponseExpected(AuthenticationException e) {
        errorResponseExpected = AuthenticationExceptionConsumer.factory(e).getErrorResponse();
    }

    private void runAssertions(String actual) {
        Assert.assertThat(actual, containsString(errorResponseExpected.getErrorCode()));
        Assert.assertThat(actual, containsString(errorResponseExpected.getMessage()));
        Assert.assertThat(actual, containsString(errorResponseExpected.getStatus().name()));
    }

    @Test
    public void testBadCredentialsHandling() throws IOException, ServletException {
        exception = new BadCredentialsException("Bad Creds");
        callErrorRequest(exception);
        setErrorResponseExpected(exception);
        String badCredentialsActual = new String(stream.toByteArray());
        runAssertions(badCredentialsActual);
    }

    @Test
    public void testExpiredTokenHandling() throws IOException, ServletException {
        exception = new JwtExpiredTokenException("Expired Token");
        callErrorRequest(exception);
        setErrorResponseExpected(exception);
        String expiredTokenActual = new String(stream.toByteArray());
        runAssertions(expiredTokenActual);
    }

    @Test
    public void testGeneralAuthErrorHandling() throws IOException, ServletException {
        exception = new AuthenticationCredentialsNotFoundException("General Error");
        callErrorRequest(exception);
        setErrorResponseExpected(exception);
        String expiredTokenActual = new String(stream.toByteArray());
        runAssertions(expiredTokenActual);
    }
}
