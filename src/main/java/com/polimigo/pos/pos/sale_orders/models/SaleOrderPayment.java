package com.polimigo.pos.pos.sale_orders.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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
public class SaleOrderPayment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal netCost;
    private BigDecimal paid;
    private BigDecimal remaining;
    private BigDecimal discount;

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
