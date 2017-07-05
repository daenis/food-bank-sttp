package com.opendatadelaware.feede.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.dao.ItemsDao;
import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.model.Items;
import com.opendatadelaware.feede.service.ItemsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by jarrydstamatelos on 6/30/17.
 */

@RunWith(SpringRunner.class)
public class TestItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestItemsController.class);

    private MockMvc mvc;

    @MockBean
    private ItemsDao itemsDao;

    @SpyBean
    private ItemsService itemsService;

    @InjectMocks
    private ItemsController controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    private String objectToString(List<Items> p) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return null;
        }
    }
    @Test
    public void test_get_by_id_success() throws Exception {
        Items items = new Items();
        
        when(userService.findById(1)).thenReturn(user);
        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.username", is("Daenerys Targaryen")));
        verify(userService, times(1)).findById(1);
        verifyNoMoreInteractions(userService);
    }

}
