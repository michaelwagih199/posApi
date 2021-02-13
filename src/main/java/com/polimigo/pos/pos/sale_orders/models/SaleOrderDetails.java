package com.polimigo.pos.pos.sale_orders.models;
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
import static javax.persistence.TemporalType.TIMESTAMP;
/**
 * @author michael wagih
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SaleOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal total;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "saleOrder_id")
    private SaleOrder saleOrder;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

}
