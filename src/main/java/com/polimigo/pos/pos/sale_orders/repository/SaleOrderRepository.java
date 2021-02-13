package com.polimigo.pos.pos.sale_orders.repository;

import com.polimigo.pos.pos.sale_orders.models.SaleOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface SaleOrderRepository extends CrudRepository<SaleOrder,Long > {
    SaleOrder findByOrderCode(String orderCode);
}
