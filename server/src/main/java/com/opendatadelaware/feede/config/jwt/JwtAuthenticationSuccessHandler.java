package com.opendatadelaware.feede.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by aaronlong on 7/6/17.
 */
@Component
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
  private final ObjectMapper mapper;
  private final TokenService tokenService;

  @Autowired
  public JwtAuthenticationSuccessHandler(final ObjectMapper aMapper,
                                         final TokenService aTokenService) {
    mapper = aMapper;
    tokenService = aTokenService;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse,
                                      Authentication authentication)
          throws IOException, ServletException {

      String principal = (String)authentication.getPrincipal();

      //Create an access Token
      JwtToken accessToken = JwtToken.createTokenInstance(principal);
      //Create a refresh token


      //Create a map to hold the two tokens that were just created
      //Place the token in the map
      //Place the refresh token in the map

      //Set the Http status to OK
      httpServletResponse.setStatus(HttpStatus.OK.value());
      //Set the content type of the response
      httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
      //Write the token values to the mapper variable
      mapper.writeValue(httpServletResponse.getWriter(), accessToken);

      //Clear the authentication attributes
      clearAuthenticationAttributes(httpServletRequest);

  }

  protected final void clearAuthenticationAttributes(HttpServletRequest request) {
    HttpSession session = request.getSession(false);

    if (session == null) {
      return;
    }

    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }
}
