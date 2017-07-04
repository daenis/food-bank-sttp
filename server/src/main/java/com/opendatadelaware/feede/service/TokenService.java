package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.TokenDao;
import com.opendatadelaware.feede.model.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by aaronlong on 7/4/17.
 */
@Service
public class TokenService extends AbstractService<TokenDao>
                          implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return null;
  }
}
