package com.opendatadelaware.feede.repository;

import com.opendatadelaware.feede.model.Orders;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

/**
 * Created by markbrown on 6/30/17.
 */
public interface OrderRepository extends CrudRepository<Orders, UUID> {}
