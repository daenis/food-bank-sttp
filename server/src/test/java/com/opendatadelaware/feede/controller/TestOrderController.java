package com.opendatadelaware.feede.controller;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.opendatadelaware.feede.model.Orders;


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
    public void testGetByIDMethod() throws Exception {
        Orders order = new Orders();
        UUID uuid = UUID.randomUUID();
        when(dao.read(uuid)).thenReturn(order);
    }



}
