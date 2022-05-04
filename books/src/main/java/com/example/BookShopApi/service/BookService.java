package com.example.BookShopApi.service;
import com.example.BookShopApi.bo.Book;


public interface BookService {
    Iterable<Book> getListeBooks();
    Book getBook(int id);
}
