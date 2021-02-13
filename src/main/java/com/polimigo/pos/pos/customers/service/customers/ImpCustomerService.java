package com.polimigo.pos.pos.customers.service.customers;

import com.polimigo.pos.pos.customers.models.Customer;
import com.polimigo.pos.pos.customers.repository.CustomerRepository;
import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author michael wagih
 */

@Service
public class ImpCustomerService implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer createObject(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public Customer updateObject(Long id, Customer object) {
        return customerRepository.findById(id).map(post -> {
            post.setCustomerName(object.getCustomerName());
            post.setCustomerPhone(object.getCustomerPhone());
            post.setNotes(object.getNotes());
            return customerRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("post id" + id + "not Found"));
    }

    @Override
    public void deleteObject(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> getAllObject() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findObject(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id"+id+"not found"));
    }

    @Override
    public Page<Customer> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Customer> pagedResult = customerRepository.findPage(paging);
        return pagedResult;
    }

    @Override
    public List<String> getNames() {
        return customerRepository.getNames();
    }

    @Override
    public List<Customer> findBycustomerName(String categoryName) {
        return customerRepository.findByCustomerName(categoryName);
    }
}
