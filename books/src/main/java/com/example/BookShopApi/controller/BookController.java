package com.example.BookShopApi.controller;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Customer;
import com.example.BookShopApi.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        @PostMapping(value = "/add/",consumes = "application/json")
        Book addBook(@RequestBody Book book){
            return bookService.createBook(book);
        }

        @DeleteMapping("/delete/{id}")
        void deleteBook(@PathVariable int id){
            bookService.deleteBook(id);
        }

        @PutMapping("/edit/")
        void modifierBook(@RequestBody Book book){
            this.bookService.updateBook(book);
        }


        @PostMapping(value = "/upImg")
        void uploadImage(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {


            byte[] bytes = file.getBytes();
            Path path = Paths.get("./../FrontEndEtudiant/src/assets/incidents/" + file.getOriginalFilename());
            Files.write(path, bytes);
            path = Paths.get("./../FrontEndAgent/src/assets/incidents/" + file.getOriginalFilename());
            Files.write(path, bytes);


            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");
        }
}
