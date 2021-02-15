package com.polimigo.pos.pos.sale_orders.services.order;
import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.sale_orders.models.SaleOrder;

/**
 * @author michael wagih
 */
public interface SaleOrderService extends BluePrintService<SaleOrder> {
    SaleOrder createOrder(SaleOrder saleOrder, String customerName, Long orderTypeId, Long paymentTypeId);
    String getNextCode(String shift);

    SaleOrder findByOrderCode(String orderCode);

}
