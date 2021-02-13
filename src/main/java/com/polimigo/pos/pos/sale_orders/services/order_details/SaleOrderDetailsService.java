package com.polimigo.pos.pos.sale_orders.services.order_details;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.sale_orders.models.SaleOrderDetails;
import com.polimigo.pos.pos.sale_orders.payload.OrderDetailsPayload;

import java.util.List;
import java.util.Map;

/**
 * @author michael wagih
 */
public interface SaleOrderDetailsService extends BluePrintService<SaleOrderDetails> {
    void createOrderDetails(OrderDetailsPayload saOrderDetailsPayload, String orderCode);
    Map<String, List<String>> checkIfItemNotEnough(OrderDetailsPayload saleOrderDetails);
    Map<String, List<String>> checkIfAlertItem(OrderDetailsPayload saleOrderDetails);

}
