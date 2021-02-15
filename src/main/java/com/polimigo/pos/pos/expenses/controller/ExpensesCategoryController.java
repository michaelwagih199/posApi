package com.polimigo.pos.pos.expenses.controller;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.expenses.models.ExpensesCategory;
import com.polimigo.pos.pos.expenses.services.expesesCategory.ExpensesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/expensesCategory")
public class ExpensesCategoryController implements BluePrintController<ExpensesCategory> {

    @Autowired
    ExpensesCategoryService expensesCategoryService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(expensesCategoryService.getAllObject());
    }

    @Override
    public ResponseEntity<Map<String, ExpensesCategory>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ExpensesCategory getObjectById(Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ExpensesCategory addObject(@RequestBody ExpensesCategory object) {
        return expensesCategoryService.createObject(object);
    }

    @PutMapping("{id}")
    @Override
    public ExpensesCategory updateObject(@PathVariable Long id,@RequestBody ExpensesCategory object) {
        return expensesCategoryService.updateObject(id,object);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable Long id) {
        expensesCategoryService.deleteObject(id);
    }

}
