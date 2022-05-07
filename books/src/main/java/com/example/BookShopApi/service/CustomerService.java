package com.example.BookShopApi.service;
import com.example.BookShopApi.bo.Customer;
import org.springframework.web.bind.annotation.*;

public interface CustomerService {

    Iterable<Customer> getListeCustomers();
    Customer getCustomer(int id);
    Customer createCustomer(Customer customer);
    void deleteCustomer(int id);
    void updateCustomer(Customer customer);






}