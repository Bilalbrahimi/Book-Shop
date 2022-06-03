package com.example.BookShopApi.service;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Category;
import com.example.BookShopApi.repository.BookRepository;
import com.example.BookShopApi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Iterable<Category> getListeCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategory(int id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        this.categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryRepository.save(category);
    }

}
