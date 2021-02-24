package com.polimigo.pos.pos.purchases.services.PurchasesBill;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.purchases.models.PurchasesBill;
import com.polimigo.pos.pos.purchases.repository.PurchasesBillRepository;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
import com.polimigo.pos.pos.suppliers.repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author michael wagih
 */
@Service
public class ImpPurshasesBillsService implements PurchasesBillService {

    @Autowired
    PurchasesBillRepository purchasesBillRepository;
    @Autowired
    SuppliersRepository suppliersRepository;

    @Override
    public PurchasesBill createPurshaseBills(PurchasesBill purchasesBill, Long supplierId) {
        purchasesBill.setMySupplier(suppliersRepository.findById(supplierId)
        .orElseThrow(() -> new ResourceNotFoundException("supplier"+supplierId+"\tnot found")));
        purchasesBill.setBillCodeCode("2100"+purchasesBillRepository.count()+12);
        return purchasesBillRepository.save(purchasesBill);
    }

    @Override
    public PurchasesBill createObject(PurchasesBill object) {
        return null;
    }

    @Override
    public PurchasesBill updateObject(Long id, PurchasesBill object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @Override
    public Iterable<PurchasesBill> getAllObject() {
        return null;
    }

    @Override
    public PurchasesBill findObject(Long id) {
        return purchasesBillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id"+id+"not found"));
    }

    @Override
    public Page<PurchasesBill> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PurchasesBill> pagedResult = purchasesBillRepository.findPage(paging);
        return pagedResult;
    }

}
