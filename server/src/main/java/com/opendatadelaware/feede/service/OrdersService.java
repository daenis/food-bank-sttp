package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.OrdersDao;
import com.opendatadelaware.feede.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by markbrown on 6/29/17.
 */
@Service
public class OrdersService extends AbstractService<OrdersDao> {

    private OrdersDao ordersDao;

    @Autowired
    public void setDao(OrdersDao anOrdersDao) { ordersDao = anOrdersDao; }

    public Orders getOrderByID(UUID uuid) {
        return ordersDao.getById(uuid);
    }

    public UUID postOrder(Orders order) {
        return ordersDao.create(order);
    }

    public void deleteOrderById(UUID uuid) {
        ordersDao.deleteById(uuid);
    }

}
