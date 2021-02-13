package com.polimigo.pos.pos.sale_orders.services.order_details;

import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import com.polimigo.pos.pos.sale_orders.models.SaleOrderDetails;
import com.polimigo.pos.pos.sale_orders.payload.OrderDetailsPayload;
import com.polimigo.pos.pos.sale_orders.repository.SaleOrderDetailsRepository;
import com.polimigo.pos.pos.sale_orders.repository.SaleOrderRepository;
import com.polimigo.pos.pos.stock.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author michael wagih
 */

@Service
public class ImpSaleOrderDetailService implements SaleOrderDetailsService {

    @Autowired
    SaleOrderDetailsRepository saleOrderDetailsRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleOrderRepository saleOrderRepository;

    @Override
    public SaleOrderDetails createObject(SaleOrderDetails object) {
        return null;
    }

    @Override
    public SaleOrderDetails updateObject(Long id, SaleOrderDetails object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {

    }

    @Override
    public Iterable<SaleOrderDetails> getAllObject() {
        return null;
    }

    @Override
    public SaleOrderDetails findObject(Long id) {
        return null;
    }

    @Override
    public Page<SaleOrderDetails> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    // in update
    @Override
    public void createOrderDetails(OrderDetailsPayload orderDetailsPayload,
                                   String orderCode) {
        orderDetailsPayload.getDynamicDetailsDaoList().forEach(post -> {
            SaleOrderDetails saleOrderDetails = new SaleOrderDetails();
            saleOrderDetails.setTotal(post.getTotal());
            saleOrderDetails.setQuantity(BigDecimal.valueOf(post.getQuantity()));
            saleOrderDetails.setPrice(post.getPrice());
            saleOrderDetails.setProduct(productRepository.findById(post.getProductId()).orElseThrow(() -> new ResourceNotFoundException("not found")));
            saleOrderDetails.setSaleOrder(saleOrderRepository.findByOrderCode(orderCode));
            //update stock
            productRepository.updateQuantityStock(post.getProductId(), post.getQuantity());

            saleOrderDetailsRepository.save(saleOrderDetails);
        });
    }

    @Override
    public Map<String,List<String>> checkIfItemNotEnough(OrderDetailsPayload saleOrderDetails) {
        Map result = new HashMap();
        List products = new LinkedList();
        saleOrderDetails.getDynamicDetailsDaoList().forEach(d -> {
            if (d.getQuantity() > productRepository.findNumberUnit(d.getProductId())){
                products.add(d.getProductName());
                result.put("message","Not Enough");
                result.put("products",products);
            }
            else
                result.put("message","can order");
        });
        return result;
    }

    @Override
    public Map<String, List<String>> checkIfAlertItem(OrderDetailsPayload saleOrderDetails) {
        Map result = new HashMap();
        List products = new LinkedList();
        saleOrderDetails.getDynamicDetailsDaoList().forEach(d -> {
            if (productRepository.findAlertUnit(d.getProductId()) > productRepository.findNumberUnit(d.getProductId()) - d.getQuantity()){
                products.add(d.getProductName());
                result.put("message","Alert Product");
                result.put("products",products);
            }
            else
                result.put("message","can order");
        });
        return result;
    }

}
