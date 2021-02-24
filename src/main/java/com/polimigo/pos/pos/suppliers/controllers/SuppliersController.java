package com.polimigo.pos.pos.suppliers.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
import com.polimigo.pos.pos.suppliers.services.suppliersService.SuppliersService;
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
@RequestMapping("api/suppliers")
public class SuppliersController implements BluePrintController<MySupplier> {

    @Autowired
    SuppliersService suppliersService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(suppliersService.getAllObject());
    }

    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, MySupplier>> getPages( @RequestParam(defaultValue = "0") Integer page,
                                                             @RequestParam(defaultValue = "6") Integer size,
                                                             @RequestParam(defaultValue = "id") String sortBy) {
        Page<MySupplier> patientPage;
        patientPage = suppliersService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("suppliers", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public MySupplier getObjectById(@PathVariable Long id) {
        return suppliersService.findObject(id);
    }

    @GetMapping("names")
    public ResponseEntity getNames() {
        return ResponseEntity.ok().body(suppliersService.findNames());
    }

    @GetMapping("supplierName")
    public ResponseEntity findBySupplierName(@RequestParam String supplierName){
        return ResponseEntity.ok().body(suppliersService.findBySupplierName(supplierName));
    }

    @PostMapping
    @Override
    public MySupplier addObject(@RequestBody MySupplier object) {
        return suppliersService.createObject(object);
    }

    @PutMapping("{id}")
    @Override
    public MySupplier updateObject(@PathVariable Long id, @RequestBody MySupplier object) {
        return suppliersService.createObject(object);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable Long id) {
        suppliersService.deleteObject(id);
    }

}
