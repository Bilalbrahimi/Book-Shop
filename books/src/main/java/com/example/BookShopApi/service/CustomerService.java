package com.example.BookShopApi.service;
import com.example.BookShopApi.bo.Customer;

public interface CustomerService {

    Iterable<Customer> getListeCustomers();
    Customer getCustomer(int id);

}