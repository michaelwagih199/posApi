package com.polimigo.pos.pos.sale_orders.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.sale_orders.models.SaleOrder;
import com.polimigo.pos.pos.sale_orders.services.order.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/saleOrders")
public class SaleOrderController implements BluePrintController<SaleOrder> {

    /* TODO: ٦‏/٢‏/٢٠٢١
     *  create order details then create order
     *  get order-code (pattern 11001-11002-11003)
     *  delete order
     *  update order
     * in create order
     *  -update quantity in stock
     *  -check quantity and alertUnits
     */

    @Autowired
    SaleOrderService saleOrderService;

    @Override
    public ResponseEntity getObject() {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, SaleOrder>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public SaleOrder getObjectById(Long id) {
        return null;
    }

    @GetMapping("nextCode")
    public ResponseEntity getNextCode(@RequestParam(defaultValue = "1") String shift){
        return ResponseEntity.ok().body(saleOrderService.getNextCode(shift));
    }

    @GetMapping("orderCode")
    public ResponseEntity findByOrderCode(@RequestParam String orderCode){
        return ResponseEntity.ok().body(saleOrderService.findByOrderCode(orderCode));
    }

    @Override
    public SaleOrder addObject(SaleOrder object) {
        return null;
    }

    @PostMapping
    public SaleOrder createOrder(@RequestBody SaleOrder saleOrder,
                                 @RequestParam(defaultValue = "0") Long customerId,
                                 @RequestParam Long orderTypeId,
                                 @RequestParam Long paymentTypeId) {
        return saleOrderService.createOrder(saleOrder, customerId, orderTypeId, paymentTypeId);
    }

    @Override
    public SaleOrder updateObject(Long id, SaleOrder object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }


}
