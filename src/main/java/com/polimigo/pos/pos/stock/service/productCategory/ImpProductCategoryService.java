package com.polimigo.pos.pos.stock.service.productCategory;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.stock.models.ProductCategory;
import com.polimigo.pos.pos.stock.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author michael wagih
 */

@Service
public class ImpProductCategoryService implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory createObject(ProductCategory object) {
        return productCategoryRepository.save(object);
    }

    @Override
    public ProductCategory updateObject(Long id, ProductCategory object) {
        return productCategoryRepository.findById(id).map(post -> {
            post.setCategoryName(object.getCategoryName());
            return productCategoryRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("post id" + id + "not Found"));
    }

    @Override
    public void deleteObject(Long id) {
        productCategoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("PostId" + id + "not found"));
        productCategoryRepository.deleteById(id);
    }

    @Override
    public Iterable<ProductCategory> getAllObject() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findObject(Long id) {
        return productCategoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("PostId" + id + "not found"));
    }

    @Override
    public Page<ProductCategory> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ProductCategory> pagedResult = productCategoryRepository.findPage(paging);
        return pagedResult;
    }

    @Override
    public List<String> getNames() {
        return productCategoryRepository.getNames();
    }

    @Override
    public List<ProductCategory> findBycategoryName(String categoryName) {
        return productCategoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public void archive(Long id) {
        productCategoryRepository.archive(true, id);
    }

}
