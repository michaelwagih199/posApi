package com.polimigo.pos.pos.suppliers.services.suppliersPayment;

import com.polimigo.pos.pos.customers.models.CustomerPayment;
import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.suppliers.models.SuppliersPayment;
import com.polimigo.pos.pos.suppliers.repositories.SuppliersPaymentRepository;
import com.polimigo.pos.pos.suppliers.repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author michael wagih
 */
@Service
public class ImpSupplierPaymentService  implements SuppliersPaymentService{

    @Autowired
    SuppliersPaymentRepository suppliersPaymentRepository;

    @Autowired
    SuppliersRepository suppliersRepository;


    @Override
    public SuppliersPayment createObject(SuppliersPayment object) {
        return null;
    }

    @Override
    public SuppliersPayment updateObject(Long id, SuppliersPayment object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @Override
    public Iterable<SuppliersPayment> getAllObject() {
        return suppliersPaymentRepository.findAll();
    }

    @Override
    public SuppliersPayment findObject(Long id) {
        return null;
    }

    @Override
    public Page<SuppliersPayment> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    @Override
    public SuppliersPayment createPayment(SuppliersPayment customerPayment, Long supplierId) {
        customerPayment.setMySupplier(suppliersRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("supplierId"+supplierId+"not found")));
        return suppliersPaymentRepository.save(customerPayment);
    }

    @Override
    public Page<SuppliersPayment> findSupplierByIdPagId(Integer pageNo, Integer pageSize, String sortBy, Long supplierId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<SuppliersPayment> pagedResult = suppliersPaymentRepository.findBySupplierId(supplierId,paging);
        return pagedResult;
    }

    @Override
    public BigDecimal getAllPayment(Long supplierId) {
        return suppliersPaymentRepository.getAllPayment(supplierId);
    }

    @Override
    public BigDecimal getSupplierCost(Long customerId) {
        return null;
    }
}
