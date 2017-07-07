package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.controller.responses.BadRequest;
import com.opendatadelaware.feede.controller.responses.Response;
import com.opendatadelaware.feede.controller.responses.Success;
import com.opendatadelaware.feede.controller.utils.RequestBodyMapper;
import com.opendatadelaware.feede.controller.utils.UserAuthValidator;
import com.opendatadelaware.feede.dao.ItemsDao;
import com.opendatadelaware.feede.dao.OrdersDao;
import com.opendatadelaware.feede.model.Items;
import com.opendatadelaware.feede.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


/**
 * Created by jarrydstamatelos on 6/30/17.
 */
@Service
public class ItemsService extends AbstractService<ItemsDao> {
    private ItemsDao itemsDao;

    @Autowired
    public void setDao(ItemsDao anItemsDao) { itemsDao = anItemsDao; }

    public Items getItemsById(UUID uuid) {
        return itemsDao.read(uuid);
    }

    public UUID postItems(Items items) {
        return itemsDao.create(items);
    }

    public void deleteItemsById(UUID uuid) {
        itemsDao.deleteByUUID(uuid);
    }


}