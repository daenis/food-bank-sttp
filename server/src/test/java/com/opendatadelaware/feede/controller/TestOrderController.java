package com.opendatadelaware.feede.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opendatadelaware.feede.controller.responses.Response;
import com.opendatadelaware.feede.dao.OrdersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.opendatadelaware.feede.model.Orders;
import com.opendatadelaware.feede.controller.responses.Success;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import java.util.Date;


import java.util.UUID;

/**
 * Created by markbrown on 7/5/17.
 */
@RunWith(SpringRunner.class)
public class TestOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);

    private MockMvc mvc;

    @Mock
    OrdersDao dao;

    @InjectMocks
    OrdersController ordersController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(ordersController).build();
    }

    @Test
    public void testGetByIDMethodShouldPass() throws Exception {
        Orders order = new Orders();
        UUID uuid = UUID.randomUUID();
        when(dao.read(uuid)).thenReturn(order);
        mvc.perform(get("/api/orders/{uuid}/", uuid))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void testGetByIDMethodShouldFailDueToWrongEndpoint() throws Exception {
        Orders order = new Orders();
        UUID uuid = UUID.randomUUID();
        when(dao.read(uuid)).thenReturn(order);
        mvc.perform(get("/api/orders/", uuid))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testSuccessfulPost() throws Exception {
        Orders order = new Orders();
        UUID uuid = UUID.randomUUID();
        String orderAsJsonString;
        try {
            orderAsJsonString = new ObjectMapper().writeValueAsString(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        when(dao.create(order)).thenReturn(uuid);
        mvc.perform(post("/api/orders/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderAsJsonString))
                .andExpect(status().isCreated());
    }

    @Test
    public void testPostWithIncorrectEndpoint() throws Exception {
        Orders order = new Orders();
        UUID uuid = order.getUUID();
        String orderAsJsonString;
        try {
            orderAsJsonString = new ObjectMapper().writeValueAsString(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        when(dao.create(order)).thenReturn(order.getUUID());
        mvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderAsJsonString))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDeleteById() throws Exception {
        Orders order = new Orders();
        UUID uuid = UUID.randomUUID();
        when(dao.read(uuid)).thenReturn(order);
        mvc.perform(delete("/api/orders/{uuid}/", uuid))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteByIdFailsBecauseOfIncorrectEndpoint() throws Exception {
        Orders order = new Orders();
        UUID uuid = UUID.randomUUID();
        when(dao.read(uuid)).thenReturn(order);
        mvc.perform(delete("/api/orders/", uuid))
                .andExpect(status().is4xxClientError());
    }





}
