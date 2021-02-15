package com.polimigo.pos.pos.expenses.services.expensesService;

import com.polimigo.pos.pos.expenses.models.Expenses;
import com.polimigo.pos.pos.expenses.repository.ExpensesCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author michael wagih
 */
@Service
public class ImpExpenses implements ExpensesService {

    @Autowired
    ExpensesRepository expensesRepository;

    @Override
    public Expenses createObject(Expenses object) {
        return null;
    }

    @Override
    public Expenses updateObject(Long id, Expenses object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @Override
    public Iterable<Expenses> getAllObject() {
        return null;
    }

    @Override
    public Expenses findObject(Long id) {
        return null;
    }

    @Override
    public Page<Expenses> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

}
