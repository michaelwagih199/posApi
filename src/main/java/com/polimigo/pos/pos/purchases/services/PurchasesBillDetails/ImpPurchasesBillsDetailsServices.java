package com.polimigo.pos.pos.purchases.services.PurchasesBillDetails;

import com.polimigo.pos.pos.purchases.models.PurchasesBill;
import com.polimigo.pos.pos.purchases.models.PurchasesBillDetails;
import com.polimigo.pos.pos.purchases.repository.PurchasesBillRepository;
import com.polimigo.pos.pos.purchases.repository.PurchasesBillsDetailsRepository;
import com.polimigo.pos.pos.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author michael wagih
 */
@Service
public class ImpPurchasesBillsDetailsServices implements PurchasesBillsDetailsServices{

    @Autowired
    PurchasesBillsDetailsRepository purchasesBillsDetailsRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PurchasesBillRepository purchasesBillRepository;

    public PurchasesBillDetails createPurchases(PurchasesBillDetails object, String billsCode, String productName) {
        object.setProduct(productRepository.findByProductName(productName).get(0));
        object.setPurchasesBill(purchasesBillRepository.findByBillCodeCode(billsCode));
        return purchasesBillsDetailsRepository.save(object);
    }
}
