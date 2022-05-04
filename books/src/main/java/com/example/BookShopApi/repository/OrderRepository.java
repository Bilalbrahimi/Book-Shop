package com.example.BookShopApi.repository;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
