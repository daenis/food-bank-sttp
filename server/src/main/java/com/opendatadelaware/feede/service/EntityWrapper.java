package com.opendatadelaware.feede.service;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by aaronlong on 7/6/17.
 */
public class EntityWrapper<T extends Serializable> {

  private T entityObject;
  private boolean populated;
  private EntityWrapper(Optional<T> entity) {
    populated = entity.isPresent();
    if (populated) {
      entityObject = entity.get();
    }
  }

  public T getEntityObject() {
    return entityObject;
  }

  public boolean isPopulated() {
    return populated;
  }

  public static <T extends Serializable> EntityWrapper<T> makeWrapper(Optional<T> entity) {
    return new EntityWrapper<>(entity);
  }
}
