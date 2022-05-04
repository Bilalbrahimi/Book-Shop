package com.example.BookShopApi.bo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import java.util.Date;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int orderId;




    @JsonIgnoreProperties({ "orders" })
    @JoinColumn(name = "customerID")
    @ManyToOne(targetEntity=Customer.class)
    private Customer customer;


/*
    @JoinColumn(name = "isbn")
    private Book book;
*/


    private Date orderDate;
    private Date shippingDate;
    private Date receiptDate;
    private int amountOrdered;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }




    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /*
    @OneToMany(targetEntity=Book.class)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
*/
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}