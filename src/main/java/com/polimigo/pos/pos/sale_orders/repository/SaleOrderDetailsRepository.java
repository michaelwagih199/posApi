package com.polimigo.pos.pos.sale_orders.repository;

import com.polimigo.pos.pos.sale_orders.models.SaleOrderDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface SaleOrderDetailsRepository extends CrudRepository<SaleOrderDetails,Long> {
}
