package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.dao.ItemsDao;
import com.opendatadelaware.feede.dao.UsersDao;
import com.opendatadelaware.feede.model.Items;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by jarrydstamatelos on 6/30/17.
 */

@RunWith(SpringRunner.class)
public class TestItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestItemsController.class);

    private MockMvc mvc;

    @MockBean
    private ItemsDao dao;

    @InjectMocks
    private ItemsController controller;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testRemoveItemByUUID() {

    }

}
