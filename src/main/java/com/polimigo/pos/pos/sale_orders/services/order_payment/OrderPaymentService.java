package com.polimigo.pos.pos.sale_orders.services.order_payment;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.sale_orders.models.SaleOrderPayment;

/**
 * @author michael wagih
 */
public interface OrderPaymentService extends BluePrintService<SaleOrderPayment> {
    SaleOrderPayment createPayment(SaleOrderPayment saleOrderPayment, String orderCode);

}
