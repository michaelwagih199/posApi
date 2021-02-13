package com.polimigo.pos.pos.sale_orders.controllers;

import com.polimigo.pos.pos.sale_orders.services.dynamic_details.DynamicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/dynamicDetails")
public class DynamicDetailsController {
    /**
     * todo get dynamic (productCode,paymentTypeId,orderTypeId)
     */
    @Autowired
    DynamicDetailsService dynamicDetailsService;

    @GetMapping
    public ResponseEntity getDynamicDetails(@RequestParam String productCode,
                                            @RequestParam Long paymentTypeId,
                                            @RequestParam Long orderTypeId,
                                            @RequestParam(defaultValue = "1") BigDecimal quantity,
                                            @RequestParam(defaultValue = "30") BigDecimal installmentPercentage) {
        return ResponseEntity.ok().body(dynamicDetailsService.getDynamicDetails(
                productCode,
                paymentTypeId,
                orderTypeId,
                quantity,
                installmentPercentage));
    }

}
