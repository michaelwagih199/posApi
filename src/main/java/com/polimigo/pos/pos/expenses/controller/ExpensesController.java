package com.polimigo.pos.pos.expenses.controller;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.expenses.models.Expenses;
import com.polimigo.pos.pos.expenses.services.expensesService.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/expenses")
public class ExpensesController implements BluePrintController<Expenses> {

    @Autowired
    ExpensesService expensesService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(expensesService.getAllObject());
    }

    @Override
    public ResponseEntity<Map<String, Expenses>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public Expenses getObjectById(Long id) {
        return null;
    }


    @PostMapping
    @Override
    public Expenses addObject(Expenses object) {
        return expensesService.createObject(object);
    }

    @PutMapping("{id}")
    @Override
    public Expenses updateObject(@PathVariable Long id,@RequestBody Expenses object) {
        return expensesService.updateObject(id,object);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable Long id) {
        expensesService.deleteObject(id);
    }

}
