package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaronlong on 6/27/17.
 */
@Service
public class UsersService extends AbstractService<Users> {
  @Autowired
  private UsersDao dao;
}
