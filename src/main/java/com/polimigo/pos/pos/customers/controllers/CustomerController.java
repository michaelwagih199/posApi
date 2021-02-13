package com.polimigo.pos.pos.customers.controllers;
import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.customers.service.customers.CustomerService;
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
@RequestMapping("api/customers")
public class CustomerController implements BluePrintController<Customer> {

    @Autowired
    CustomerService customerService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(customerService.getAllObject());
    }

    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, Customer>> getPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "6") Integer size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<Customer> patientPage;
        patientPage = customerService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("customers", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public Customer getObjectById(@PathVariable @Positive Long id) {
        return customerService.findObject(id);
    }

    @GetMapping("/names")
    public ResponseEntity getNames(){
        return ResponseEntity.ok().body(customerService.getNames());
    }

    @GetMapping("customerName")
    public ResponseEntity findBycategoryName(@RequestParam String customerName){
        return ResponseEntity.ok().body(customerService.findBycustomerName(customerName));
    }

    @PostMapping
    @Override
    public Customer addObject(@RequestBody Customer object) {
        return customerService.createObject(object);
    }

    @PutMapping("{id}")
    @Override
    public Customer updateObject(@Positive @PathVariable Long id, @RequestBody Customer object) {
        return customerService.updateObject(id, object);
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@PathVariable @Positive Long id) {
        customerService.deleteObject(id);
    }

}
