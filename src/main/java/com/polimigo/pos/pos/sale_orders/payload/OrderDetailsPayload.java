package com.polimigo.pos.pos.sale_orders.payload;
import com.polimigo.pos.pos.sale_orders.dao.DynamicDetailsDao;
import lombok.Data;
import java.util.List;

/**
 * @author michael wagih
 */

@Data
public class OrderDetailsPayload {
    private List<DynamicDetailsDao> dynamicDetailsDaoList;
}
