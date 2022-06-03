package com.example.BookShopApi.service;



import com.example.BookShopApi.bo.Category;

public interface CategoryService {
    Iterable<Category> getListeCategories();
    Category getCategory(int id);
    Category createCategory(Category category);
    void deleteCategory(int id);
    void updateCategory(Category category);
}
