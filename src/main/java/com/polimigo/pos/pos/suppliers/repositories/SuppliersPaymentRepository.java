package com.polimigo.pos.pos.suppliers.repositories;

import com.polimigo.pos.pos.customers.models.CustomerPayment;
import com.polimigo.pos.pos.suppliers.models.SuppliersPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

/**
 * @author michael wagih
 */

public interface SuppliersPaymentRepository extends CrudRepository<SuppliersPayment,Long> {

    @Query("SELECT s FROM SuppliersPayment s WHERE s.mySupplier.id =:supplierId")
    Page<SuppliersPayment> findBySupplierId(Long supplierId, Pageable paging);

    @Query("SELECT sum(s.paymentValue) FROM SuppliersPayment s  WHERE s.mySupplier.id =:supplierId")
    BigDecimal getAllPayment(Long supplierId);

}
