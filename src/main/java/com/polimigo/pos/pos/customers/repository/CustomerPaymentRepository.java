package com.polimigo.pos.pos.customers.repository;

import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.customers.models.CustomerPayment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author michael wagih
 */
public interface CustomerPaymentRepository extends CrudRepository<CustomerPayment,Long> {

    @Query("SELECT c FROM CustomerPayment c WHERE c.customer.id =:customerId")
    Page<CustomerPayment> findByCustomerId(Long customerId,Pageable paging);

    @Query("SELECT sum(c.paymentValue) FROM CustomerPayment c WHERE c.customer.id =:customerId")
    BigDecimal getAllPayment(Long customerId);
}
