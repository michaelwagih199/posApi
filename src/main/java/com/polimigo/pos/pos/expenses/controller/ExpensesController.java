package com.polimigo.pos.pos.expenses.controller;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.expenses.models.Expenses;
import com.polimigo.pos.pos.expenses.services.expensesService.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, Expenses>> getPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "6") Integer size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Expenses> patientPage;
        patientPage = expensesService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("expenses", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public Expenses getObjectById(Long id) {
        return null;
    }

    @Override
    public Expenses addObject(@RequestBody Expenses object) {
        return null;
    }

    @PostMapping
    public Expenses createExpenses(@RequestBody Expenses object, @RequestParam Long categoryId) {
        return expensesService.createExpenses(object, categoryId);
    }

    @PutMapping("{id}")
    @Override
    public Expenses updateObject(@PathVariable Long id, @RequestBody Expenses object) {
        return expensesService.updateObject(id, object);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable Long id) {
        expensesService.deleteObject(id);
    }

}
