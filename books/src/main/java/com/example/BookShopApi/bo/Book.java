package com.example.BookShopApi.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Book {

    @Id
    @NonNull
    private int isbn;
    private String title;
    private String author;
    private String editor;
    private String ean;
    private String price;
    private String summary;

    private int numberCopiesInStock;

    private Date date;
    private int numberPages;
    private String weight;
    private String note;
    private String format;
    private String presentation;

    @JsonIgnoreProperties({ "books" })
    @JoinColumn(name = "orderId")
    @ManyToOne(targetEntity=Order.class)
    private Order order;

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumberCopiesInStock(int numberCopiesInStock) {
        this.numberCopiesInStock = numberCopiesInStock;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    public String getEan() {
        return ean;
    }

    public String getPrice() {
        return price;
    }

    public String getSummary() {
        return summary;
    }

    public int getNumberCopiesInStock() {
        return numberCopiesInStock;
    }

    public Date getDate() {
        return date;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public String getWeight() {
        return weight;
    }

    public String getNote() {
        return note;
    }

    public String getFormat() {
        return format;
    }

    public String getPresentation() {
        return presentation;
    }


}