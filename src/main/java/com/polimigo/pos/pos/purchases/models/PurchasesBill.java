package com.polimigo.pos.pos.purchases.models;
import com.polimigo.pos.pos.suppliers.models.MySupplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import static javax.persistence.TemporalType.TIMESTAMP;
/**
 * @author michael wagih
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PurchasesBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String billCodeCode;
    private String billCodeSerial;

    @Temporal(TIMESTAMP)
    protected Date billsDate;
    private String notes;
    private BigDecimal total;
    private BigDecimal paid;
    private BigDecimal remaining;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mySupplier_id")
    private MySupplier mySupplier;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "details")
    private Set<PurchasesBillDetails> purchasesBillDetails;

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
