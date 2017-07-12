package com.opendatadelaware.feede.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.config.jwt.token.JwtToken;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.model.Users;
import com.opendatadelaware.feede.model.fields.TokenType;
import com.opendatadelaware.feede.service.EntityWrapper;
import com.opendatadelaware.feede.service.TokenService;
import com.opendatadelaware.feede.service.UserService;
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
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * Created by aaronlong on 7/6/17.
 */
@Component
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
  private final ObjectMapper mapper;
  private TokenService tokenService;
  private UserService userService;

  @Autowired
  public JwtAuthenticationSuccessHandler(final ObjectMapper aMapper) {
    mapper = aMapper;
  }

  @Autowired
  public void setTokenService(TokenService theTokenService) {
    tokenService = theTokenService;
  }

  @Autowired
  public void setUserService(UserService theUserService) {
    userService = theUserService;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse,
                                      Authentication authentication)
          throws IOException, ServletException {
      JwtToken token = (JwtToken) authentication.getCredentials();
      Map<String, String> tokenMap = Collections.singletonMap("token", token.getTokenString());

      //Create a map to hold the two tokens that were just created
      //Place the token in the map
      //Place the refresh token in the map

      //Set the Http status to OK
      httpServletResponse.setStatus(HttpStatus.OK.value());
      //Set the content type of the response
      httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
      //Write the token values to the mapper variable
      mapper.writeValue(httpServletResponse.getWriter(), tokenMap);

      //Clear the authentication attributes
      clearAuthenticationAttributes(httpServletRequest);

  }

  public EntityWrapper<Tokens> generateTokenBasedOnUser(EntityWrapper<Users> user, HttpStatus status, TokenType type) {
    type = TokenType.USER;
    EntityWrapper<Tokens> token = EntityWrapper.makeWrapper( Optional.of(new Tokens().setUser(user.getEntityObject())
            .setTokenType(type).setActive(status.is2xxSuccessful())));
    return token;
  }

  protected final void clearAuthenticationAttributes(HttpServletRequest request) {
    HttpSession session = request.getSession(false);

    if (session == null) {
      return;
    }

    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }
}
