package com.polimigo.pos.pos.suppliers.services.suppliersPayment;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.customers.models.CustomerPayment;
import com.polimigo.pos.pos.suppliers.models.SuppliersPayment;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

/**
 * @author michael wagih
 */

public interface SuppliersPaymentService extends BluePrintService<SuppliersPayment> {
    public abstract SuppliersPayment createPayment(SuppliersPayment customerPayment, Long supplierId);
    Page<SuppliersPayment> findSupplierByIdPagId(Integer pageNo, Integer pageSize, String sortBy, Long customerId);
    BigDecimal getAllPayment(Long customerId);
    BigDecimal getSupplierCost(Long customerId);
}
