package com.example.BookShopApi.service;

import com.example.BookShopApi.exceptions.BookNotFoundException;
import com.example.BookShopApi.model.Book;
import com.example.BookShopApi.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getBooks () {
        return repo.findAll();
    }

    public Book getBook (Long id) {
        return repo.findById(id).orElseThrow(() ->
                new BookNotFoundException("Book by id " + id + " was not found."));
    }

    public Book addBook (Book book) {
        return repo.save(book);
    }

    public Book updateBook (Long id, Book book) {
        Book oldBook = getBook(id);

        oldBook.setName(book.getName());
        oldBook.setDescription(book.getDescription());
        oldBook.setPrice(book.getPrice());
        oldBook.setImage(book.getImage());

        return repo.save(oldBook);
    }

    public void deleteBook (Long id) {
        repo.deleteById(id);
    }
}