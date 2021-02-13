package com.polimigo.pos.pos.customers.service.customer_payments;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.customers.models.CustomerPayment;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author michael wagih
 */
public interface CustomerPaymentService extends BluePrintService<CustomerPayment> {
    public abstract CustomerPayment createPayment(CustomerPayment customerPayment,Long customerId);

    Page<CustomerPayment> findByCustomerId(Integer pageNo, Integer pageSize, String sortBy, Long customerId);

    BigDecimal getAllPayment(Long customerId);

}
