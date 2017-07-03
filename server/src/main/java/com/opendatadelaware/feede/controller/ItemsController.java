package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.dao.ItemsDao;
import com.opendatadelaware.feede.model.Items;
import com.opendatadelaware.feede.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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
    public ResponseEntity<?> deleteItemByUUID(@PathVariable Items uuid) {
        itemsDao.delete(uuid);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getItems() {
        return new ResponseEntity<Object>("Forbidden Action", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addItems(@RequestBody Map<String, String> s) {
        return new ResponseEntity<Object>("Forbidden Action", HttpStatus.FORBIDDEN);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateItems(@RequestBody Map<String, String> s) {
        return new ResponseEntity<Object>("Forbidden Action", HttpStatus.FORBIDDEN);
    }

}
