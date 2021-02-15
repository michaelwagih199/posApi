package com.polimigo.pos.pos.expenses.repository;

import com.polimigo.pos.pos.expenses.models.ExpensesCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface ExpensesCategoryRepository extends CrudRepository<ExpensesCategory,Long> {
}
