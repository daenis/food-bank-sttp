package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.service.UsersService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aaronlong on 6/27/17.
 */
@RestController
@RequestMapping("/api/user")
public class UsersController {
  @Autowired
  private UsersService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> getUsers() {
    return new ResponseEntity<Authenticator.Success>(HttpStatus.OK);
  }

}
