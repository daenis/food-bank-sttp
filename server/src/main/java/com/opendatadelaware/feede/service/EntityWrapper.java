package com.opendatadelaware.feede.service;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;

/**
 * Created by aaronlong on 7/6/17.
 */
public class EntityWrapper<T extends Serializable> {

  private T entityObject;
  private EntityWrapper(T entity) {
    entityObject = entity;
  }

  public T getEntityObject() {
    return entityObject;
  }

  public static <T extends Serializable> EntityWrapper<T> makeWrapper(T entity) {
    return new EntityWrapper<>(entity);
  }
}
