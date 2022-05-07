package com.example.BookShopApi.service;



import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Order;
import com.example.BookShopApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }


    @Override
    public Iterable<Order> getListeOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order getOrder(int id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        this.orderRepository.save(order);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(Order order) {
        this.orderRepository.save(order);
    }


}