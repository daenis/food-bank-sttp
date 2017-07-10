package com.opendatadelaware.feede.config.jwt;

import com.opendatadelaware.feede.config.WebSecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.opendatadelaware.feede.config.jwt.token.JwtToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by denniskalaygian on 7/5/17.
 */
@Component
public class JwtTokenFilter extends AbstractAuthenticationProcessingFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;
    private static final String defaultUrl = "/api/user/login";
    private JwtSettings settings;

    @Autowired
    public JwtTokenFilter(AuthenticationSuccessHandler theSuccessHandler,
                          AuthenticationFailureHandler theFailureHandler) {
        super(defaultUrl);
        successHandler = theSuccessHandler;
        failureHandler = theFailureHandler;
    }

    @Autowired
    public void setSettings(JwtSettings settings) {
        this.settings = settings;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        if (!HttpMethod.POST.name().equals(httpServletRequest.getMethod())) {
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("Authentication method not supported. Request method: " + httpServletRequest.getMethod());
            }
            throw new HttpRequestMethodNotSupportedException("Authentication method not supported");
        }
        String tokenHeader = httpServletRequest.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM);
        JwtToken token = JwtToken.createTokenInstanceFromHeader(tokenHeader, settings.getTokenSigningKey());
        return getAuthenticationManager().authenticate(new JwtAuthenticationToken(token));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        failureHandler.onAuthenticationFailure(request, response, failed);
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
