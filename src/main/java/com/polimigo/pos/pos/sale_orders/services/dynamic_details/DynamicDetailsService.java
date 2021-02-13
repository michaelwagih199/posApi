package com.polimigo.pos.pos.sale_orders.services.dynamic_details;

import com.polimigo.pos.pos.sale_orders.dao.DynamicDetailsDao;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author michael wagih
 */
public interface DynamicDetailsService {
    DynamicDetailsDao getDynamicDetails(String productCode, Long paymentTypeId, Long orderTypeId,
                                              BigDecimal quantity,
                                              BigDecimal installmentPercentage);
}
