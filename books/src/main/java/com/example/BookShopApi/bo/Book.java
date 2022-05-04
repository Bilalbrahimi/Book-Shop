package com.example.BookShopApi.bo;

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