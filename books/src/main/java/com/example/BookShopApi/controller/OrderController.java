package com.example.BookShopApi.controller;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Order;
import com.example.BookShopApi.service.BookService;
import com.example.BookShopApi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(value="/all")
    Iterable<Order> getAllOrders(){
        return this.orderService.getListeOrders();
    }

    @GetMapping(value="/id/{id}")
    Order getOrder(@PathVariable int id){
        return this.orderService.getOrder(id);
    }

}