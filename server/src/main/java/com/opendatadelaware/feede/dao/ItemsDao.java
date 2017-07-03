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

    public void delete(UUID o) {
        getSession().delete(o);
    }

}
