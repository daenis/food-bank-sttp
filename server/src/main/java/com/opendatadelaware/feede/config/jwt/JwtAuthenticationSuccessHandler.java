package com.opendatadelaware.feede.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.model.Tokens;
import com.opendatadelaware.feede.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
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

    Tokens accessToken = new Tokens();
  }

  protected final void clearAuthenticationAttributes(HttpServletRequest request) {
    HttpSession session = request.getSession(false);

    if (session == null) {
      return;
    }

    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }
}
