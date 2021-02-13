package com.polimigo.pos.pos.customers.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.customers.models.CustomerPayment;
import com.polimigo.pos.pos.customers.service.customer_payments.CustomerPaymentService;
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
@RequestMapping("api/customerPayments")
public class CustomerPaymentController implements BluePrintController<CustomerPayment> {

    @Autowired
    CustomerPaymentService customerPaymentService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return ResponseEntity.ok().body(customerPaymentService.getAllObject());
    }

    @Override
    public ResponseEntity<Map<String, CustomerPayment>> getPages(@RequestParam(defaultValue = "0") Integer page,
                                                                 @RequestParam(defaultValue = "6") Integer size,
                                                                 @RequestParam(defaultValue = "id") String sortBy) {
        return null;
    }

    @GetMapping("{id}")
    @Override
    public CustomerPayment getObjectById(@PathVariable Long id) {
        return customerPaymentService.findObject(id);
    }


    @GetMapping("customer")
    public ResponseEntity findByCustomerId(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "6") Integer size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam Long customerId) {

        Page<CustomerPayment> patientPage;
        patientPage = customerPaymentService.findByCustomerId(page, size, sortBy, customerId);
        Map<String, Object> response = new HashMap<>();
        response.put("customerPayment", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("totalPayment")
    public ResponseEntity getAllPayment(@RequestParam Long customerId) {
        return ResponseEntity.ok().body(customerPaymentService.getAllPayment(customerId));
    }

    @Override
    public CustomerPayment addObject(@RequestBody CustomerPayment object) {
        return null;
    }

    @PostMapping
    public CustomerPayment createPayment(@RequestBody CustomerPayment customerPayment,
                                         @RequestParam Long customerId) {
        return customerPaymentService.createPayment(customerPayment, customerId);
    }

    @PutMapping
    @Override
    public CustomerPayment updateObject(@PathVariable Long id, @RequestBody CustomerPayment object) {
        return customerPaymentService.updateObject(id, object);
    }

    @DeleteMapping
    @Override
    public void deleteObject(Long id) {
        customerPaymentService.deleteObject(id);
    }

}
