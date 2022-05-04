package com.example.BookShopApi.service;


import com.example.BookShopApi.bo.Order;

public interface OrderService {

    Iterable<Order> getListeOrders();
    Order getOrder(int id);
}
