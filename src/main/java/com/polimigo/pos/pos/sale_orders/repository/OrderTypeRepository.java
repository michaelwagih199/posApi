package com.polimigo.pos.pos.sale_orders.repository;

import com.polimigo.pos.pos.sale_orders.models.OrderType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface OrderTypeRepository extends CrudRepository<OrderType,Long> {
}
