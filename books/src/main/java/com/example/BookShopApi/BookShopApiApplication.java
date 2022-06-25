package com.example.BookShopApi;


import com.example.BookShopApi.model.Book;
import com.example.BookShopApi.model.Commande;
import com.example.BookShopApi.model.User;
import com.example.BookShopApi.model.cart.CartItem;
import com.example.BookShopApi.model.cart.CartItemPK;
import com.example.BookShopApi.repo.BookRepository;
import com.example.BookShopApi.repo.CartItemRepository;
import com.example.BookShopApi.repo.CommandeRepository;
import com.example.BookShopApi.repo.UserRepository;
import com.example.BookShopApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class BookShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookShopApiApplication.class, args);
	}



}
