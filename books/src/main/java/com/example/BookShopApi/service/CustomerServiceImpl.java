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

    @Override
    public Customer createCustomer(Customer customer) {
        this.customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }
}