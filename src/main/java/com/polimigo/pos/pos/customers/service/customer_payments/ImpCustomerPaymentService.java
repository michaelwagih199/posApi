package com.polimigo.pos.pos.customers.service.customer_payments;

import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.customers.models.CustomerPayment;
import com.polimigo.pos.pos.customers.repository.CustomerPaymentRepository;
import com.polimigo.pos.pos.customers.repository.CustomerRepository;
import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.sale_orders.repository.SaleOrderPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author michael wagih
 */

@Service
public class ImpCustomerPaymentService implements CustomerPaymentService {

    @Autowired
    CustomerPaymentRepository customerPaymentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SaleOrderPaymentRepository saleOrderPaymentRepository;

    @Override
    public CustomerPayment createObject(CustomerPayment object) {
        return null;
    }

    @Override
    public CustomerPayment updateObject(Long id, CustomerPayment object) {
         return customerPaymentRepository.findById(id).map(post -> {
            post.setCustomer(object.getCustomer());
            post.setId(object.getId());
            post.setNotes(object.getNotes());
            post.setPaymentDate(object.getPaymentDate());
            post.setCreatedDate(object.getCreatedDate());
            post.setPaymentValue(object.getPaymentValue());
            return customerPaymentRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("id" + id + "not Found"));
    }

    @Override
    public void deleteObject(Long id) {
        customerPaymentRepository.deleteById(id);
    }

    @Override
    public Iterable<CustomerPayment> getAllObject() {
        return customerPaymentRepository.findAll();
    }

    @Override
    public CustomerPayment findObject(Long id) {
        return customerPaymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id" + id + "not found"));
    }

    @Override
    public Page<CustomerPayment> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    @Override
    public CustomerPayment createPayment(CustomerPayment customerPayment, Long customerId) {
        customerPayment.setCustomer(customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("customerId"+customerId+"not found")));
        return customerPaymentRepository.save(customerPayment);
    }

    @Override
    public Page<CustomerPayment> findByCustomerId(Integer pageNo, Integer pageSize, String sortBy,Long customerId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CustomerPayment> pagedResult = customerPaymentRepository.findByCustomerId(customerId,paging);
        return pagedResult;
    }

    @Override
    public BigDecimal getAllPayment(Long customerId) {
        return customerPaymentRepository.getAllPayment(customerId);
    }

    @Override
    public BigDecimal getCustomerOrderCost(Long customerId) {
        return saleOrderPaymentRepository.customerNetCostOrder(customerId);
    }


}
