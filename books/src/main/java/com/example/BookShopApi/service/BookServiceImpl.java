package com.example.BookShopApi.service;


import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookrepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookrepository=bookRepository;
    }

    @Override
    public Iterable<Book> getListeBooks() {
        return this.bookrepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        return this.bookrepository.findById(id).orElse(null);
    }
}
