package com.polimigo.pos.pos.expenses.services.expensesService;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.expenses.models.Expenses;
import com.polimigo.pos.pos.expenses.repository.ExpensesCategoryRepository;
import com.polimigo.pos.pos.expenses.repository.ExpensesRepository;
import com.polimigo.pos.pos.stock.models.Product;
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
public class ImpExpenses implements ExpensesService {

    @Autowired
    ExpensesRepository expensesRepository;
    @Autowired
    ExpensesCategoryRepository expensesCategoryRepository;

    @Override
    public Expenses createObject(Expenses object) {
        return null;
    }

    @Override
    public Expenses updateObject(Long id, Expenses object) {
        return expensesRepository.findById(id).map(post -> {
            post.setExpensesCategory(object.getExpensesCategory());
            post.setExpensesName(object.getExpensesName());
            post.setNotes(object.getNotes());
            return expensesRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("id not found"));
    }

    @Override
    public void deleteObject(Long id) {
        expensesRepository.deleteById(id);
    }

    @Override
    public Iterable<Expenses> getAllObject() {
        return expensesRepository.findAll();
    }

    @Override
    public Expenses findObject(Long id) {
        return null;
    }

    @Override
    public Page<Expenses> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Expenses> pagedResult = expensesRepository.findPage(paging);
        return pagedResult;
    }

    @Override
    public Expenses createExpenses(Expenses expenses, Long categoryId) {
        expenses.setExpensesCategory(expensesCategoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("categoryId not found")));
        return expensesRepository.save(expenses);
    }
}
