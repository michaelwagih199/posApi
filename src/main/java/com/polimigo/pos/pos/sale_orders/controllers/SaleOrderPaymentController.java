package com.polimigo.pos.pos.sale_orders.controllers;

import com.polimigo.pos.pos.bluPrint.BluePrintController;
import com.polimigo.pos.pos.sale_orders.models.SaleOrderPayment;
import com.polimigo.pos.pos.sale_orders.services.order_payment.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/saleOrdersPayments")
public class SaleOrderPaymentController implements BluePrintController<SaleOrderPayment> {

    @Autowired
    OrderPaymentService orderPaymentService;

    @Override
    public ResponseEntity getObject() {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, SaleOrderPayment>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public SaleOrderPayment getObjectById(Long id) {
        return null;
    }

    @Override
    public SaleOrderPayment addObject(SaleOrderPayment object) {
        return null;
    }


    @Override
    public SaleOrderPayment updateObject(Long id, SaleOrderPayment object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }
    /**
     * todo create payment(Payment,orderCode)
     *
     */

    @PostMapping
    public SaleOrderPayment createPayment(@RequestBody SaleOrderPayment saleOrderPayment,
                                          @RequestParam String orderCode){
        return orderPaymentService.createPayment(saleOrderPayment,orderCode);
    }

}
