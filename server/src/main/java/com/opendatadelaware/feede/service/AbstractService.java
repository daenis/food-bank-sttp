package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aaronlong on 6/27/17.
 * @see <a href =
 * "https://raw.githubusercontent.com/eugenp/tutorials/master/spring-security-rest-full/src/main/java/org/baeldung/persistence/service/common/AbstractService.java"> AbstractService Template</a>
 *
 */
public abstract class AbstractService <T extends AbstractDao> {
  protected T dao;

  @Autowired
  public void setDao(T daoInstance) {
    dao = daoInstance;
  }

}
