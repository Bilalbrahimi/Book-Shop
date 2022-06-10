package com.example.BookShopApi.repo;

import com.example.BookShopApi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteById(Long id);
    Optional<Book> findById (Long id);
}
