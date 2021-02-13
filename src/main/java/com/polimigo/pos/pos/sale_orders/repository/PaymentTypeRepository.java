package com.polimigo.pos.pos.sale_orders.repository;

import com.polimigo.pos.pos.sale_orders.models.PaymentType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface PaymentTypeRepository extends CrudRepository<PaymentType,Long> {
}
