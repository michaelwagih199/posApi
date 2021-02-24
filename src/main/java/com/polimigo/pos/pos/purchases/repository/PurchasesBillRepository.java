package com.polimigo.pos.pos.purchases.repository;

import com.polimigo.pos.pos.purchases.models.PurchasesBill;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface PurchasesBillRepository extends CrudRepository<PurchasesBill,Long> {
    @Query("SELECT p FROM PurchasesBill p")
    Page<PurchasesBill>findPage(Pageable paging);
}
