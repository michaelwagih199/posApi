package com.polimigo.pos.pos.expenses.services.expesesCategory;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.expenses.models.ExpensesCategory;
import com.polimigo.pos.pos.expenses.repository.ExpensesCategoryRepository;
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
public class ImpExpensesCategoryService implements ExpensesCategoryService {
    @Autowired
    ExpensesCategoryRepository expensesCategoryRepository;

    @Override
    public ExpensesCategory createObject(ExpensesCategory object) {
        return expensesCategoryRepository.save(object);
    }

    @Override
    public ExpensesCategory updateObject(Long id, ExpensesCategory object) {
        return expensesCategoryRepository.findById(id).map(post -> {
            post.setCategoryName(object.getCategoryName());
            return expensesCategoryRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("categoryId".concat(String.valueOf(id)).concat("notFound")));
    }

    @Override
    public void deleteObject(Long id) {
        expensesCategoryRepository.deleteById(id);
    }

    @Override
    public Iterable<ExpensesCategory> getAllObject() {
        return expensesCategoryRepository.findAll();
    }

    @Override
    public ExpensesCategory findObject(Long id) {
        return null;
    }


    @Override
    public Page<ExpensesCategory> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ExpensesCategory> pagedResult = expensesCategoryRepository.findPage(paging);
        return pagedResult;
    }

    @Override
    public List<String> getAllName() {
        return expensesCategoryRepository.getCategoryNames();
    }

    @Override
    public List<ExpensesCategory> findBycategoryName(String categoryName) {
        return expensesCategoryRepository.findByCategoryName(categoryName);
    }

}
