package com.polimigo.pos.pos.sale_orders.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.sale_orders.models.SaleOrderDetails;
import com.polimigo.pos.pos.sale_orders.payload.OrderDetailsPayload;
import com.polimigo.pos.pos.sale_orders.services.order_details.SaleOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/saleOrderDetails")
public class SaleOrderDetailsController implements BluePrintController<SaleOrderDetails> {

    @Autowired
    SaleOrderDetailsService saleOrderDetailsService;

    @Override
    public ResponseEntity getObject() {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, SaleOrderDetails>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public SaleOrderDetails getObjectById(Long id) {
        return null;
    }

    @Override
    public SaleOrderDetails addObject(SaleOrderDetails object) {
        return null;
    }

    @Override
    public SaleOrderDetails updateObject(Long id, SaleOrderDetails object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    // custom logic

    @PostMapping
    public void createOrderDetails(@RequestBody OrderDetailsPayload saleOrderDetails,
                                   @RequestParam String orderCode) {
        saleOrderDetailsService.createOrderDetails(saleOrderDetails, orderCode);
    }
    // TODO: ١٢‏/٢‏/٢٠٢١ check unit in stock - check alert unit
    @PostMapping("/ifItemNotEnough")
    public ResponseEntity checkIfItemNotEnough(@RequestBody OrderDetailsPayload saleOrderDetails){
        return ResponseEntity.ok().body(saleOrderDetailsService.checkIfItemNotEnough(saleOrderDetails));
    }

    @PostMapping("/ifAlertItem")
    public ResponseEntity checkIfAlertItem(@RequestBody OrderDetailsPayload saleOrderDetails){
        return ResponseEntity.ok().body(saleOrderDetailsService.checkIfAlertItem(saleOrderDetails));
    }

}
