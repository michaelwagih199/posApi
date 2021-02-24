package com.polimigo.pos.pos.suppliers.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.customers.models.CustomerPayment;
import com.polimigo.pos.pos.suppliers.models.SuppliersPayment;
import com.polimigo.pos.pos.suppliers.services.suppliersPayment.SuppliersPaymentService;
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
@RequestMapping("api/supplierPayments")
public class SupplierPaymentController implements BluePrintService<SuppliersPayment> {
    @Autowired
    SuppliersPaymentService suppliersPaymentService;

    @Override
    public SuppliersPayment createObject(SuppliersPayment object) {
        return null;
    }


    @Override
    public SuppliersPayment updateObject(Long id, SuppliersPayment object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @GetMapping
    @Override
    public Iterable<SuppliersPayment> getAllObject() {
        return suppliersPaymentService.getAllObject();
    }

    @Override
    public SuppliersPayment findObject(Long id) {
        return null;
    }

    @Override
    public Page<SuppliersPayment> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    @GetMapping("supplier")
    public ResponseEntity findBySupplierId(@RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "6") Integer size,
                                           @RequestParam(defaultValue = "id") String sortBy,
                                           @RequestParam Long supplierId) {

        Page<SuppliersPayment> patientPage;
        patientPage = suppliersPaymentService.findSupplierByIdPagId(page, size, sortBy, supplierId);
        Map<String, Object> response = new HashMap<>();
        response.put("supplierPayment", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("totalPayment")
    public ResponseEntity getAllPayment(@RequestParam Long supplierId) {
        return ResponseEntity.ok().body(suppliersPaymentService.getAllPayment(supplierId));
    }

    @PostMapping
    public SuppliersPayment createPayment(@RequestBody SuppliersPayment suppliersPayment,
                                         @RequestParam Long supplierId) {
        return suppliersPaymentService.createPayment(suppliersPayment, supplierId);
    }

}
