package com.polimigo.pos.pos.sale_orders.services.order;

import com.polimigo.pos.pos.customers.repository.CustomerRepository;
import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.sale_orders.models.SaleOrder;
import com.polimigo.pos.pos.sale_orders.models.SaleOrderDetails;
import com.polimigo.pos.pos.sale_orders.repository.OrderTypeRepository;
import com.polimigo.pos.pos.sale_orders.repository.PaymentTypeRepository;
import com.polimigo.pos.pos.sale_orders.repository.SaleOrderRepository;
import com.polimigo.pos.pos.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michael wagih
 */
@Service
public class ImpSaleOrderService implements SaleOrderService {

    @Autowired
    SaleOrderRepository saleOrderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderTypeRepository orderTypeRepository;
    @Autowired
    PaymentTypeRepository paymentTypeRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public SaleOrder createObject(SaleOrder object) {
        return saleOrderRepository.save(object);
    }

    @Override
    public SaleOrder updateObject(Long id, SaleOrder object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @Override
    public Iterable<SaleOrder> getAllObject() {
        return null;
    }

    @Override
    public SaleOrder findObject(Long id) {
        return null;
    }

    @Override
    public Page<SaleOrder> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }


    @Override
    public SaleOrder createOrder(SaleOrder saleOrder, Long customerId, Long orderTypeId, Long paymentTypeId ) {

        if (customerId==0)
            saleOrder.setCustomer(customerRepository.findByCustomerName("عميل كاش").get(0));
        else
            saleOrder.setCustomer(customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("id" + customerId + "not found")));
        saleOrder.setOrderCode(getNextCode("1"));
        saleOrder.setOrderType(orderTypeRepository.findById(orderTypeId).orElseThrow(() -> new ResourceNotFoundException("orderType Id not found")));
        saleOrder.setPaymentType(paymentTypeRepository.findById(paymentTypeId).orElseThrow(() -> new ResourceNotFoundException("paymentTypeId not found")));

        return saleOrderRepository.save(saleOrder);
    }

    @Override
    public String getNextCode(String shift) {
        return "1".concat(shift).concat("00").concat(String.valueOf(saleOrderRepository.count()+1));
    }

    @Override
    public SaleOrder findByOrderCode(String orderCode) {
        return saleOrderRepository.findByOrderCode(orderCode);
    }
}
