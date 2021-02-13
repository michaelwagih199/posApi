package com.polimigo.pos.pos.sale_orders.services.order_payment;

import com.polimigo.pos.pos.sale_orders.models.SaleOrderPayment;
import com.polimigo.pos.pos.sale_orders.repository.SaleOrderPaymentRepository;
import com.polimigo.pos.pos.sale_orders.repository.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author michael wagih
 */
@Service
public class ImpSaleOrderPayment implements OrderPaymentService{
    @Autowired
    SaleOrderPaymentRepository saleOrderPaymentRepository;
    @Autowired
    SaleOrderRepository saleOrderRepository;

    @Override
    public SaleOrderPayment createObject(SaleOrderPayment object) {
        return null;
    }

    @Override
    public SaleOrderPayment updateObject(Long id, SaleOrderPayment object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @Override
    public Iterable<SaleOrderPayment> getAllObject() {
        return null;
    }

    @Override
    public SaleOrderPayment findObject(Long id) {
        return null;
    }

    @Override
    public Page<SaleOrderPayment> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    @Override
    public SaleOrderPayment createPayment(SaleOrderPayment saleOrderPayment, String orderCode) {
        saleOrderPayment.setSaleOrder(saleOrderRepository.findByOrderCode(orderCode));
        return saleOrderPaymentRepository.save(saleOrderPayment);
    }
}
