package com.polimigo.pos.pos.stock.service.products;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.stock.models.Product;
import com.polimigo.pos.pos.stock.repositories.ProductCategoryRepository;
import com.polimigo.pos.pos.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author michael wagih
 */

@Service
public class ImpProductService implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public Product createObject(Product object) {
        return productRepository.save(object);
    }

    @Override
    public Product updateObject(Long id, Product object) {
        return productRepository.findById(id).map(product -> {
            product.setAlertUnits(object.getAlertUnits());
            product.setId(object.getId());
            product.setProductCategory(object.getProductCategory());
            product.setNumberUnitsInStock(object.getNumberUnitsInStock());
            product.setProductName(object.getProductName());
            product.setProductCode(object.getProductCode());
            product.setWholesalePrice(object.getWholesalePrice());
            product.setPurchasingPrice(object.getPurchasingPrice());
            product.setRetailPrice(object.getRetailPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("id" + id + "not Found"));
    }

    @Override
    public void deleteObject(Long id) {
        productRepository.deleteById(id);
//        productRepository.findById(id).map(product -> {
//            productRepository.delete(product);
//            return "delete successfull";
//        }).orElseThrow(() -> new ResourceNotFoundException("id" + id + "not found"));
    }

    @Override
    public Iterable<Product> getAllObject() {
        return productRepository.findAll();
    }

    @Override
    public Product findObject(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id" + id + "not found"));
    }

    @Override
    public Page<Product> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult = productRepository.findPage(paging);
        return pagedResult;
    }

    @Override
    public Product createProduct(Product product, Long categoryId) {
        product.setProductCategory(productCategoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("id" + categoryId + "not found")));
        // generate code
        if (product.getProductCode().equals("automatic"))
            product.setProductCode("1010" + ThreadLocalRandom.current().nextInt(0, 10000 + 1)+"01");
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product object, Long categoryId) {
        return productRepository.findById(productId).map(product -> {
            product.setAlertUnits(object.getAlertUnits());
            product.setId(object.getId());
            product.setProductCategory(productCategoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category id not found")));
            product.setNumberUnitsInStock(object.getNumberUnitsInStock());
            product.setProductName(object.getProductName());
            product.setProductCode(object.getProductCode());
            product.setWholesalePrice(object.getWholesalePrice());
            product.setPurchasingPrice(object.getPurchasingPrice());
            product.setRetailPrice(object.getRetailPrice());
            return productRepository.save(product);
        }).orElseThrow(() -> new ResourceNotFoundException("id" + productId + "not Found"));
    }

    @Override
    public List<String> getNames() {
        return productRepository.getNames();
    }

    @Override
    public List<Product> findByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> findByCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

}
