package com.example.BookShopApi.service;


import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Order;

public interface OrderService {

    Iterable<Order> getListeOrders();
    Order getOrder(int id);
    Order createOrder(Order order);
    void deleteOrder(int id);
    void updateOrder(Order order);
}
