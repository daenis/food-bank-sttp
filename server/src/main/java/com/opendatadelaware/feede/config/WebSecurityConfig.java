package com.opendatadelaware.feede.config;

import com.opendatadelaware.feede.config.jwt.JwtAuthenticationProvider;
import com.opendatadelaware.feede.config.jwt.JwtSettings;
import com.opendatadelaware.feede.config.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by aaronlong on 6/28/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";

  private AuthenticationManager authenticationManager;
  private AuthenticationSuccessHandler successHandler;
  private AuthenticationFailureHandler failureHandler;

  private JwtAuthenticationProvider jwtAuthenticationProvider;
  private JwtSettings jwtSettings;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
            .antMatchers("/api/user").permitAll()
            .antMatchers(HttpMethod.POST, "/api/user/login").permitAll()
            .and()
            .authorizeRequests()
                      .anyRequest().authenticated()
            .and()
              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
              .addFilterBefore(buildFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  private JwtTokenFilter buildFilter() {
    JwtTokenFilter filter = new JwtTokenFilter(successHandler, failureHandler, jwtSettings);
    filter.setAuthenticationManager(this.authenticationManager);
    return filter;
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
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void authenticationManager(AuthenticationManager manager) {
    authenticationManager = manager;
  }

  @Autowired
  public void setJwtAuthenticationProvider(JwtAuthenticationProvider theJwtAuthenticationProvider) {
    jwtAuthenticationProvider = theJwtAuthenticationProvider;
  }

  @Autowired
  public void setSuccessHandler(AuthenticationSuccessHandler successHandler) {
    this.successHandler = successHandler;
  }

  @Autowired
  public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
    this.failureHandler = failureHandler;
  }

  @Autowired
  public void setJwtSettings(JwtSettings theSettings) {
    jwtSettings = theSettings;
  }
}
