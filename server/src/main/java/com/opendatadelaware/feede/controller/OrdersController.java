package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.model.Orders;
import com.opendatadelaware.feede.repository.OrderRepository;
import com.opendatadelaware.feede.service.OrdersService;
import com.opendatadelaware.feede.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by markbrown on 6/29/17.
 */

@RequestMapping("/api/orders")
@RestController
public class OrdersController {

    private OrdersService service;

    @Autowired
    public void setOrderService(OrdersService orderService) {
        service = orderService;
    }

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> postOrder(@RequestBody Orders order) {
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PathVariable UUID uuid) {
        return new ResponseEntity<>(orderRepository.findOne(uuid), HttpStatus.OK);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public ResponseEntity<?> editOrder(@RequestBody Orders order, @PathVariable UUID uuid) {
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable UUID uuid) {
        return new ResponseEntity<>(orderRepository.delete(uuid), HttpStatus.OK);
    }












}
