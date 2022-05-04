package com.example.BookShopApi.service;

import com.example.BookShopApi.bo.Customer;
import com.example.BookShopApi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Iterable<Customer> getListeCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(int id){
        return customerRepository.findById(id).orElse(null);
    }

}