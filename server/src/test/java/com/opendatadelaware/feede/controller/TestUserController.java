package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.dao.UsersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by aaronlong on 6/28/17.
 */
@RunWith(SpringRunner.class)
public class TestUserController {

  private MockMvc mvc;

  @MockBean
  private UsersDao dao;

  @InjectMocks
  private UsersController controller;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void testPutBadInput() throws Exception {
    String badAuth = "eyIiOiIiLCJoZXkiOiJ3aGF0c3VwIiwibm8iOiJwcm9mYW5pdHkiLCJkZW5uaXMiOiJtYXJpb2thcnRtYXN0ZXIifQ==";
    String badInput = String.format("{ \"auth\" : %s}", badAuth);
    this.mvc.perform(put("/api/user")
            .contentType(MediaType.APPLICATION_JSON).content(badInput))
              .andExpect(status().isBadRequest());
  }

  @Test
  public void testPutValidInput() throws Exception {
    String validAuth = "eyJmaXJzdE5hbWUiOiJEZW5uaXMiLCJsYXN0TmFtZSI6IkthbGF5Z2lhbiIsImVtYWlsIjoiZGVubmlza2FsYXlnaWFuQGdtYWlsLmNvbSIsInBhc3N3b3JkIjoiMTIzNDUiLCJwaG9uZSI6IjMwMjMzMzMzMzMiLCJzdHJlZXQiOiI4MTEgQmlyY2ggQXZlIiwiY2l0eSI6Ik1pbGZvcmQiLCJzdGF0ZSI6IkRFIiwiemlwIjoiMTk5NjMifQ==";
  }
}
