package com.opendatadelaware.feede.dao;

import org.springframework.stereotype.Repository;
import com.opendatadelaware.feede.model.Orders;
import java.util.UUID;

/**
 * Created by markbrown on 6/29/17.
 */

@Repository
public class OrdersDao extends AbstractDao<Orders, UUID> {

    public OrdersDao () {
        super(Orders.class);
    }

    public Orders getById(UUID uuid) {
        return getSession().load(Orders.class, uuid);
    }

    public void deleteById(UUID uuid) {
        Orders order = getSession().load(Orders.class, uuid);
        getSession().delete(order);
        getSession().flush();
    }

}
