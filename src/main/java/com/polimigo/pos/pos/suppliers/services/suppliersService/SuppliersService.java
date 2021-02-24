package com.polimigo.pos.pos.suppliers.services.suppliersService;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.suppliers.models.MySupplier;

import java.util.List;

/**
 * @author michael wagih
 */
public interface SuppliersService extends BluePrintService<MySupplier> {
    List<String> findNames();
    List<MySupplier> findBySupplierName(String supplierName);
}
