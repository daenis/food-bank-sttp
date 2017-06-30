package com.opendatadelaware.feede.controller;

import com.opendatadelaware.feede.model.Orders;
import com.opendatadelaware.feede.service.OrdersService;
import com.opendatadelaware.feede.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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









}
