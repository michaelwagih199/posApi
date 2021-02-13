package com.polimigo.pos.pos.stock.controllers;
import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.stock.models.Product;
import com.polimigo.pos.pos.stock.models.ProductCategory;
import com.polimigo.pos.pos.stock.service.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author michael wagih
 */

@RestController
@RequestMapping("api/products")
public class ProductController implements BluePrintController<Product> {

    @Autowired
    ProductService productService;

    @Override
    public ResponseEntity getObject() {
        return null;
    }


    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, Product>> getPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "6") Integer size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<Product> patientPage;
        patientPage = productService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("products", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public Product getObjectById(@PathVariable Long id) {
        return productService.findObject(id);
    }

    @GetMapping("names")
    public ResponseEntity  getNames(){
        return  ResponseEntity.ok().body(productService.getNames());
    }

    @GetMapping("productName")
    public  ResponseEntity findByName(@RequestParam String productName){
        return ResponseEntity.ok().body(productService.findByName(productName));
    }

    @GetMapping("productCode")
    public ResponseEntity findByCode(@RequestParam String productCode){
        return ResponseEntity.ok().body(productService.findByCode(productCode));
    }

    @Override
    public Product addObject(Product object) {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product, @RequestParam Long categoryId){
        return productService.createProduct(product,categoryId);
    }

    @PutMapping
    public Product updateProduct(@RequestParam @Positive Long productId,@RequestBody Product product, @RequestParam @Positive Long categoryId){
        return productService.updateProduct(productId,product,categoryId);
    }

    @Override
    public Product updateObject(Long id, Product object) {
        return null;
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable Long id) {
        productService.deleteObject(id);
    }

}
