package com.polimigo.pos.pos.stock.repositories;

import com.polimigo.pos.pos.stock.models.Product;
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
public interface ProductRepository  extends CrudRepository<Product,Long> {
    @Query("SELECT p FROM Product p")
    Page<Product> findPage(Pageable paging);
    @Query("SELECT p.productName FROM Product p")
    List<String> getNames();
    @Query("SELECT p.productName FROM Product p where p.productCode =:productCode")
    String findByProductCodeBind(String productCode);

    @Query("SELECT p.numberUnitsInStock FROM Product p where p.id =:productId")
    int findNumberUnit(long productId);
    @Query("SELECT p.alertUnits FROM Product p where p.id =:productId")
    int findAlertUnit(Long productId);

    @Transactional
    @Modifying
    @Query(value ="update product p set p.number_units_in_stock = p.number_units_in_stock - :numberSale where p.id =:productId",nativeQuery = true)
    void updateQuantityStock(@Param("productId") Long productId,@Param("numberSale") int numberSale);
    List<Product>findByProductName(String productName);
    List<Product> findByProductCode(String productCode);

}
