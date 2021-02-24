package com.polimigo.pos.pos.sale_orders.models;

import com.polimigo.pos.pos.customers.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
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
public class SaleOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderCode;

    @Temporal(TIMESTAMP)
    protected Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "orderType_id")
    private OrderType orderType;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentType_id")
    private PaymentType paymentType;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

}
