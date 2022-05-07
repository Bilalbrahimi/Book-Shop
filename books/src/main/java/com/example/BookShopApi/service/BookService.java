package com.example.BookShopApi.service;
import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Customer;


public interface BookService {
    Iterable<Book> getListeBooks();
    Book getBook(int id);
    Book createBook(Book book);
    void deleteBook(int id);
    void updateBook(Book book);
}
