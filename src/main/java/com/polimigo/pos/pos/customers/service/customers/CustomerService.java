package com.polimigo.pos.pos.customers.service.customers;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.customers.models.Customer;

import java.util.List;

/**
 * @author michael wagih
 */
public interface CustomerService extends BluePrintService<Customer> {
    List<String> getNames();
    List<Customer> findBycustomerName(String categoryName);
}
