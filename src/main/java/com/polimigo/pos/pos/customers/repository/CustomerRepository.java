package com.polimigo.pos.pos.customers.repository;

import com.polimigo.pos.pos.customers.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author michael wagih
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c")
    Page<Customer> findPage(Pageable paging);

    @Query("SELECT c.customerName FROM Customer c")
    List<String> getNames();

    List<Customer> findByCustomerName(String customerName);

}
