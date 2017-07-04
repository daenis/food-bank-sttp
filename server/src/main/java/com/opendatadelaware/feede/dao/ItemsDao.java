package com.opendatadelaware.feede.dao;

import com.opendatadelaware.feede.model.Items;
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

    public void addItem(Items item) {
        getSession().save(item);
    }

    public Items getItemByUUID(UUID uuid) {
        return getSession().get(Items.class, uuid);
    }

    public void updateItemByUUID(UUID uuid) {
        getSession().update(uuid);
    }

    public void deleteByUUID(UUID uuid) {
        getSession().delete(uuid);
    }
}
