package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.model.Items;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by jarrydstamatelos on 6/30/17.
 */
@Repository
public class ItemsDao extends AbstractDao<Items, UUID> {

    public ItemsDao () {
        super(Items.class);
    }

    public void deleteByUUID(UUID uuid) {
            Items items;
            items = getSession().load(Items.class, uuid);
            getSession().delete(items);
            getSession().flush();
    }

}
