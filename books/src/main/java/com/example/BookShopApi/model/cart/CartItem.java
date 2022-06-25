package com.example.BookShopApi.model.cart;

import javax.persistence.*;

import com.example.BookShopApi.model.Book;
import com.example.BookShopApi.model.Commande;
import com.example.BookShopApi.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @EmbeddedId
    @JsonIgnore
    private CartItemPK pk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date addedOn = new Date();

    @Column(nullable = false)
    private int quantity = 1;

    public CartItem () {

    }

    public CartItem (User user, Book book, int quantity) {
        pk = new CartItemPK();
        pk.setUser(user);
        pk.setBook(book);
        this.quantity = quantity;
    }

    @Transient
    public Book getBook () {
        return pk.getBook();
    }

    @Transient
    public double getTotalPrice () {
        return quantity * getBook().getPrice();
    }

    public CartItemPK getPk() {
        return pk;
    }

    public void setPk(CartItemPK pk) {
        this.pk = pk;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CartItem that = (CartItem) o;
        return Objects.equals(pk.getUser().getId(), that.pk.getUser().getId()) &&
                Objects.equals(getBook().getId(), that.getBook().getId());
    }
}
