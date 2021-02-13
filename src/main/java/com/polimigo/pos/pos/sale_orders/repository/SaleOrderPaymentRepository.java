package com.polimigo.pos.pos.sale_orders.repository;

import com.polimigo.pos.pos.sale_orders.models.SaleOrderPayment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface SaleOrderPaymentRepository extends CrudRepository<SaleOrderPayment,Long> {

}
