package com.polimigo.pos.pos.purchases.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.purchases.models.PurchasesBill;
import com.polimigo.pos.pos.purchases.services.PurchasesBill.PurchasesBillService;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
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
@RequestMapping("api/purchasesBills")
public class PurchasesBillController implements BluePrintController<PurchasesBill> {

    @Autowired
    PurchasesBillService purchasesBillService;

    //custom method
    @PostMapping
    public PurchasesBill createPurchasesBill(@RequestBody PurchasesBill purchasesBill, @RequestParam Long supplierId) {
        return purchasesBillService.createPurshaseBills(purchasesBill,supplierId);
    }

    @Override
    public ResponseEntity getObject() {
        return null;
    }

    @GetMapping("pageable")
    @Override
    public ResponseEntity<Map<String, PurchasesBill>> getPages(@RequestParam(defaultValue = "0") Integer page,
                                                               @RequestParam(defaultValue = "6") Integer size,
                                                               @RequestParam(defaultValue = "id") String sortBy) {
        Page<PurchasesBill> patientPage;
        patientPage = purchasesBillService.getPages(page, size, sortBy);
        Map<String, Object> response = new HashMap<>();
        response.put("purchasesBills", patientPage.getContent());
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public PurchasesBill getObjectById(@PathVariable Long id) {
        return purchasesBillService.findObject(id);
    }

    @Override
    public PurchasesBill addObject(PurchasesBill object) {
        return null;
    }

    @Override
    public PurchasesBill updateObject(Long id, PurchasesBill object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }
}
