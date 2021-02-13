package com.polimigo.pos.pos.stock.repositories;

import com.polimigo.pos.pos.stock.models.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author michael wagih
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory,Long> {

    @Query("SELECT p FROM ProductCategory p")
    Page<ProductCategory> findPage(Pageable paging);

    @Query("SELECT p.categoryName FROM ProductCategory p")
    List<String> getNames();

    List<ProductCategory> findByCategoryName(String categoryName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE ProductCategory p set p.isArchived =:isArchived WHERE p.id =:id")
    void archive(@Param("isArchived") Boolean isArchived, @Param("id") Long id);

}
