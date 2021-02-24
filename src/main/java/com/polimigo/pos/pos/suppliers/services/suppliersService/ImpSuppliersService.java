package com.polimigo.pos.pos.suppliers.services.suppliersService;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
import com.polimigo.pos.pos.suppliers.repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author michael wagih
 */
@Service
public class ImpSuppliersService implements SuppliersService {

    @Autowired
    SuppliersRepository suppliersRepository;

    @Override
    public List<String> findNames() {
        return suppliersRepository.getNames();
    }

    @Override
    public List<MySupplier> findBySupplierName(String supplierName) {
        return suppliersRepository.findBySupplierName(supplierName);
    }

    @Override
    public MySupplier createObject(MySupplier object) {
        return suppliersRepository.save(object);
    }

    @Override
    public MySupplier updateObject(Long id, MySupplier object) {
        return suppliersRepository.findById(id)
                .map(post -> {
                    post.setId(object.getId());
                    post.setNotes(object.getNotes());
                    post.setSupplierAddress(object.getSupplierAddress());
                    post.setSupplierCompany(object.getSupplierCompany());
                    post.setSupplierName(object.getSupplierName());
                    post.setSupplierPhone(object.getSupplierPhone());
                    return suppliersRepository.save(post);
                }).orElseThrow(() -> new ResourceNotFoundException("id not found"));
    }

    @Override
    public void deleteObject(Long id) {
        suppliersRepository.deleteById(id);
    }

    @Override
    public Iterable<MySupplier> getAllObject() {
        return suppliersRepository.findAll();
    }

    @Override
    public MySupplier findObject(Long id) {
        return suppliersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id\t"+id+"notFound"));
    }

    @Override
    public Page<MySupplier> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MySupplier> pagedResult = suppliersRepository.findPage(paging);
        return pagedResult;
    }
}
