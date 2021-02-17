package com.polimigo.pos.pos.suppliers.models;

import com.polimigo.pos.pos.stock.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author michael wagih
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PurchasesBillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int itemQuantity;
    private BigDecimal itemPrice;
    private BigDecimal total;

    /**
     * relation
     */
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "purchasesBill_id")
    private PurchasesBill purchasesBill;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Product> products;

    /**
     * crated date
     */
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;
    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }
}
