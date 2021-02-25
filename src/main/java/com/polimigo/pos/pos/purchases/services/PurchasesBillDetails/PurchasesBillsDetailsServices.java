package com.polimigo.pos.pos.purchases.services.PurchasesBillDetails;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.purchases.models.PurchasesBillDetails;

/**
 * @author michael wagih
 */
public interface PurchasesBillsDetailsServices  {
    PurchasesBillDetails createPurchases(PurchasesBillDetails object, String billsCode, String productName);
}
