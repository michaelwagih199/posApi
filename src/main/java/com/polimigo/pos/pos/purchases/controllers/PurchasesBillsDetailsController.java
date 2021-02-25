package com.polimigo.pos.pos.purchases.controllers;

import com.polimigo.pos.pos.purchases.models.PurchasesBillDetails;
import com.polimigo.pos.pos.purchases.services.PurchasesBillDetails.PurchasesBillsDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author michael wagih
 */
@RestController
@RequestMapping("api/purchasesBillsDetails")
public class PurchasesBillsDetailsController {

    @Autowired
    PurchasesBillsDetailsServices purchasesBillsDetailsServices;

    /**
     * custom end point
     */

    @PostMapping
    public PurchasesBillDetails create(@RequestBody PurchasesBillDetails object,
                                       @RequestParam String billsCode,
                                       @RequestParam String productName){
        return purchasesBillsDetailsServices.createPurchases(object,billsCode,productName);
    }

}
