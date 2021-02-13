package com.polimigo.pos.pos.sale_orders.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author michael wagih
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicDetailsDao {
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total;
    private String unitType;
}
