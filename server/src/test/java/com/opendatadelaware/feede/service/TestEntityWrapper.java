package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.model.Tokens;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;


/**
 * Created by aaronlong on 7/7/17.
 */
public class TestEntityWrapper {
  private EntityWrapper<Tokens> token;

  @Before
  public void setUp() {
    token = EntityWrapper.makeWrapper(Optional.of(new Tokens()));
  }

  @Test
  public void testEntityCreation() {
    token = EntityWrapper.makeWrapper(Optional.of(new Tokens()));
    Assert.assertTrue("Confirm object was created", token.isPopulated());
  }

  @Test
  public void testTokenReturn() {
    token = EntityWrapper.makeWrapper(Optional.of(new Tokens()));
    Assert.assertTrue("Confirm object was created", token.getEntityObject() != null);
  }
}
