package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.controller.responses.Success;
import com.opendatadelaware.feede.dao.ItemsDao;
import com.opendatadelaware.feede.model.Items;
import com.opendatadelaware.feede.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

/**
 * Created by jarrydstamatelos on 6/30/17.
 */
@RestController
@RequestMapping("/items/{uuid}")
public class ItemsController {

    private ItemsService service;
    private ItemsDao itemsDao;

    @Autowired
    public void setItemsService(ItemsService aService) {
        service = aService;
        service.setDao(itemsDao);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteItemByUUID(@PathVariable UUID uuid) {
        itemsDao.deleteByUUID(uuid);
        return new Success().makeResponse(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Items> get(@PathVariable UUID uuid) {
        return new ResponseEntity<>(itemsDao.read(uuid), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> addItems(@PathVariable Items items){
        itemsDao.create(items);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
