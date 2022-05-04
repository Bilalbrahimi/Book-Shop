package com.example.BookShopApi.controller;


import com.example.BookShopApi.bo.Customer;
import com.example.BookShopApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;


    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(value="/all")
    Iterable<Customer> getAllCustomers(){
        return this.customerService. getListeCustomers();
    }

    @GetMapping(value="/id/{id}")
    Customer getCustomer(@PathVariable int id){
        return this.customerService.getCustomer(id);
    }



}