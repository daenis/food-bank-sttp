package com.opendatadelaware.feede.service;

import com.opendatadelaware.feede.dao.ItemsDao;
import com.opendatadelaware.feede.model.Items;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jarrydstamatelos on 6/30/17.
 */
@Service
public class ItemsService extends AbstractService<ItemsDao> {
    private ItemsDao itemsDao;

}
