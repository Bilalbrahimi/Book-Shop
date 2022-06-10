package com.example.BookShopApi.model.cart;

import com.example.BookShopApi.model.Book;
import com.example.BookShopApi.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemPK implements Serializable {
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public CartItemPK () {

    }

    public CartItemPK(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CartItemPK that = (CartItemPK) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(user, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book);
    }
}