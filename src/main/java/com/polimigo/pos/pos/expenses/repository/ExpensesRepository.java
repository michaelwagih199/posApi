package com.polimigo.pos.pos.expenses.repository;

import com.polimigo.pos.pos.expenses.models.Expenses;
import com.polimigo.pos.pos.stock.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author michael wagih
 */
public interface ExpensesRepository extends CrudRepository<Expenses,Long> {
    @Query("SELECT e FROM Expenses e")
    Page<Expenses> findPage(Pageable paging);

}
