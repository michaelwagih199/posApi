package com.polimigo.pos.pos.purchases.services.PurchasesBill;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.purchases.models.PurchasesBill;

/**
 * @author michael wagih
 */
public interface PurchasesBillService extends BluePrintService<PurchasesBill> {
    PurchasesBill createPurshaseBills(PurchasesBill purchasesBill, Long supplierId);
    String getNextCode();

}
