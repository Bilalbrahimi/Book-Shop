package com.example.BookShopApi.controller;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Category;
import com.example.BookShopApi.service.BookService;
import com.example.BookShopApi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService){

        this.categoryService = categoryService;
    }

    @GetMapping(value="/all")
    Iterable<Category> getAllCategories(){
        return this.categoryService.getListeCategories();
    }

    @GetMapping(value="/id/{id}")
    Category getCategory(@PathVariable int id){
        return this.categoryService.getCategory(id);
    }

    @PostMapping(value = "/add/",consumes = "application/json")
    Category addCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

    @PutMapping("/edit/")
    void modifierCategory(@RequestBody Category category){
        this.categoryService.updateCategory(category);
    }

}
