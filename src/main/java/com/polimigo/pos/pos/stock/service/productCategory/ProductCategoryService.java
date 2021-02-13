package com.polimigo.pos.pos.stock.service.productCategory;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.stock.models.ProductCategory;

import java.util.List;

/**
 * @author michael wagih
 */

public interface ProductCategoryService extends BluePrintService<ProductCategory> {
    List<String> getNames();
    List<ProductCategory> findBycategoryName(String categoryName);
    void archive(Long id);
}
