package com.opendatadelaware.feede.config;

import com.opendatadelaware.feede.config.jwt.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by aaronlong on 6/28/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";

  private AuthenticationSuccessHandler successHandler;
  private AuthenticationFailureHandler failureHandler;

  private JwtAuthenticationProvider jwtAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().ignoringAntMatchers("/api/user");

    http.authorizeRequests()
            .antMatchers("/api/user")
            .permitAll()
            .antMatchers("/**/*")
            .denyAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(jwtAuthenticationProvider);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  protected BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void setJwtAuthenticationProvider(JwtAuthenticationProvider theJwtAuthenticationProvider) {
    jwtAuthenticationProvider = theJwtAuthenticationProvider;
  }

  public void setSuccessHandler(AuthenticationSuccessHandler successHandler) {
    this.successHandler = successHandler;
  }

  @Autowired
  public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
    this.failureHandler = failureHandler;
  }
}
