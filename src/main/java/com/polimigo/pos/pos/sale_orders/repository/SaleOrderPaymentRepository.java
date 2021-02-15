package com.polimigo.pos.pos.sale_orders.repository;

import com.polimigo.pos.pos.sale_orders.models.SaleOrderPayment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author michael wagih
 */
public interface SaleOrderPaymentRepository extends CrudRepository<SaleOrderPayment,Long> {
    @Query("SELECT sum(s.netCost) FROM SaleOrderPayment s WHERE s.saleOrder.customer.id =:customerId")
    BigDecimal customerNetCostOrder(Long customerId);
}
