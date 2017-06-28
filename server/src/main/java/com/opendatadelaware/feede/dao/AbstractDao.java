package com.opendatadelaware.feede.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by aaronlong on 6/27/17.
 */
public class AbstractDao<E extends Serializable, K> {
  @Autowired
  protected SessionFactory sessionFactory;

  protected Session currentSession() {
    return sessionFactory.getCurrentSession();
  }
}
