package com.polimigo.pos.pos.expenses.repository;

import com.polimigo.pos.pos.expenses.models.ExpensesCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author michael wagih
 */
public interface ExpensesCategoryRepository extends CrudRepository<ExpensesCategory,Long> {
    @Query("SELECT e FROM ExpensesCategory e")
    Page<ExpensesCategory> findPage(Pageable paging);

    @Query("SELECT e.categoryName FROM ExpensesCategory e")
    List<String>getCategoryNames();

    List<ExpensesCategory> findByCategoryName(String categoryName);

}
