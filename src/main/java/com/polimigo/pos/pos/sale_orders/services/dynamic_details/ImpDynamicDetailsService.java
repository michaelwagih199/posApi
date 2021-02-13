package com.polimigo.pos.pos.sale_orders.services.dynamic_details;

import com.polimigo.pos.pos.sale_orders.dao.DynamicDetailsDao;
import com.polimigo.pos.pos.sale_orders.repository.OrderTypeRepository;
import com.polimigo.pos.pos.sale_orders.repository.PaymentTypeRepository;
import com.polimigo.pos.pos.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author michael wagih
 */

@Service
public class ImpDynamicDetailsService implements DynamicDetailsService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    PaymentTypeRepository paymentTypeRepository;
    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Override
    public DynamicDetailsDao getDynamicDetails(String productCode, Long paymentTypeId, Long orderTypeId, BigDecimal quantity, BigDecimal installmentPercentage) {
        DynamicDetailsDao dynamicDetailsDao = new DynamicDetailsDao();
        BigDecimal priceBigDecimal = new BigDecimal(0.0);
        if (orderTypeId == 1) {
            priceBigDecimal = productRepository.findByProductCode(productCode).get(0).getWholesalePrice();
        } else if (orderTypeId == 2) {
            priceBigDecimal = productRepository.findByProductCode(productCode).get(0).getRetailPrice();
        }
        if (paymentTypeId == 2) {
            priceBigDecimal = priceBigDecimal.add(priceBigDecimal.multiply(installmentPercentage.divide(BigDecimal.valueOf(100))));
        }
        dynamicDetailsDao.setProductId(productRepository.findByProductCode(productCode).get(0).getId());
        dynamicDetailsDao.setProductName(productRepository.findByProductCodeBind(productCode));
        dynamicDetailsDao.setQuantity(quantity.intValue());
        dynamicDetailsDao.setUnitType("قطعة");
        dynamicDetailsDao.setPrice(priceBigDecimal);
        dynamicDetailsDao.setTotal(quantity.multiply(priceBigDecimal));
        
        return dynamicDetailsDao;
    }


}
