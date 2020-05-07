package com.database.marketPhones.service;

import com.database.marketPhones.model.Customer;
import com.database.marketPhones.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long idS){
        return customerRepository.getOne(idS);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public void deleteById(Long idS){
        customerRepository.deleteById(idS);
    }
}
