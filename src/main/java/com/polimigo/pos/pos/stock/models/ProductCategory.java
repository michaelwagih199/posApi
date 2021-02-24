package com.polimigo.pos.pos.stock.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "categoryName is required")
    private String categoryName;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @Type(type="yes_no")
    private  Boolean isArchived;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        isArchived =false;
    }

}
