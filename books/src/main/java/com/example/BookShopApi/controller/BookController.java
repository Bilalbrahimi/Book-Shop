package com.example.BookShopApi.controller;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
public class BookController {

        @Autowired
        private final BookService bookService;

       BookController(BookService bookService){
           this.bookService = bookService;
        }

        @GetMapping(value="/all")
        Iterable<Book> getAllBooks(){
            return this.bookService. getListeBooks();
        }

        @GetMapping(value="/id/{id}")
        Book getBook(@PathVariable int id){
           return this.bookService.getBook(id);
        }

}
