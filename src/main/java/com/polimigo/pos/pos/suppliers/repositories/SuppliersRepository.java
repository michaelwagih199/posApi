package com.polimigo.pos.pos.suppliers.repositories;

import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author michael wagih
 */
public interface SuppliersRepository extends CrudRepository<MySupplier,Long> {

    @Query("SELECT s FROM MySupplier s")
    Page<MySupplier> findPage(Pageable paging);

    @Query("SELECT s.supplierName FROM MySupplier s")
    List<String> getNames();

    List<MySupplier> findBySupplierName(String supplierName);
}
