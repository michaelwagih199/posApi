package com.polimigo.pos.pos.expenses.controller;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.expenses.models.ExpensesCategory;
import com.polimigo.pos.pos.expenses.services.expesesCategory.ExpensesCategoryService;
import com.polimigo.pos.pos.stock.models.Product;
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
@RequestMapping("api/expensesCategory")
public class ExpensesCategoryController implements BluePrintController<ExpensesCategory> {

    @Autowired
    ExpensesCategoryService expensesCategoryService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(expensesCategoryService.getAllObject());
    }

    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, ExpensesCategory>> getPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "6") Integer size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<ExpensesCategory> patientPage;
        patientPage = expensesCategoryService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("expensesCategories", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
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

    @GetMapping("/names")
    public ResponseEntity getName(){
        return ResponseEntity.ok().body(expensesCategoryService.getAllName());
    }

    @GetMapping("categoryName")
    public ResponseEntity findBycategoryName(@RequestParam String categoryName){
        return ResponseEntity.ok().body(expensesCategoryService.findBycategoryName(categoryName));
    }

}
