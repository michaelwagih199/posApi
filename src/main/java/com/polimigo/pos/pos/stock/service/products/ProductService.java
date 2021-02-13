package com.polimigo.pos.pos.stock.service.products;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.stock.models.Product;

import java.util.List;

/**
 * @author michael wagih
 */

public interface ProductService extends BluePrintService<Product> {
    public abstract  Product createProduct(Product product,Long CategoryId);
    public abstract  Product updateProduct(Long productId, Product product, Long CategoryId);
    public abstract List<String>getNames();
    public abstract List<Product>findByName(String productName);
    List<Product>findByCode(String productCode);
}
