package com.example.BookShopApi.controller;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Order;
import com.example.BookShopApi.service.BookService;
import com.example.BookShopApi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add/",consumes = "application/json")
    Order addOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }

    @PutMapping("/edit/")
    void modifierOrder(@RequestBody Order order){
        this.orderService.updateOrder(order);
    }
}