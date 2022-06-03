package com.example.BookShopApi.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category {

    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int categoryID;
    private String title;

    @ElementCollection(targetClass=Book.class)
    @JsonIgnoreProperties({ "category" })
    @OneToMany(mappedBy="category",cascade = CascadeType.ALL)//cascade = CascadeType.REMOVE)
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Category() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
