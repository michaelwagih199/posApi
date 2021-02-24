package com.polimigo.pos.pos.stock.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author michael wagih
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    @NotNull(message = "productName is required")
    private String productName;
    private BigDecimal retailPrice;
    private BigDecimal WholesalePrice;
    private BigDecimal purchasingPrice;
    private int numberUnitsInStock;
    private int alertUnits;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

}
