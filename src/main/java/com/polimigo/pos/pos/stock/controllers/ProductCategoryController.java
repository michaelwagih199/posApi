package com.polimigo.pos.pos.stock.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.stock.models.ProductCategory;
import com.polimigo.pos.pos.stock.service.productCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

/**
 * @author michael wagih
 */


@RestController
@RequestMapping("api/productCategory")
public class ProductCategoryController implements BluePrintController<ProductCategory> {

    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(productCategoryService.getAllObject());
    }

    @GetMapping("/names")
    public ResponseEntity getNames(){
        return ResponseEntity.ok().body(productCategoryService.getNames());
    }

    @GetMapping("categoryName")
    public ResponseEntity findBycategoryName(@RequestParam String categoryName){
        return ResponseEntity.ok().body(productCategoryService.findBycategoryName(categoryName));
    }

    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, ProductCategory>> getPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "6") Integer size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<ProductCategory> patientPage;
        patientPage = productCategoryService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("categories", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ProductCategory getObjectById(@PathVariable @Positive Long id) {
        return productCategoryService.findObject(id);
    }

    @PostMapping
    @Override
    public ProductCategory addObject(@RequestBody ProductCategory object) {
        return productCategoryService.createObject(object);
    }

    @PutMapping("{id}")
    @Override
    public ProductCategory updateObject(@PathVariable @Positive Long id, @RequestBody ProductCategory object) {
        return productCategoryService.updateObject(id, object);
    }

    @PutMapping("archive")
    public void archive(@RequestParam Long id){
        productCategoryService.archive(id);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable @Positive Long id) {
        productCategoryService.deleteObject(id);
    }

}
