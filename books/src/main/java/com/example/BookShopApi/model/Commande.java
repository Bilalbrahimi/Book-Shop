package com.example.BookShopApi.model;

import com.example.BookShopApi.model.cart.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int commandeId;


    public String getlBooks() {
        return lBooks;
    }

    public void setlBooks(String lBooks) {
        this.lBooks = lBooks;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }

    @Column(nullable = false)
    private String lBooks="";

    @Column(nullable = false)
    private String quantities="";

    @Column(nullable = false)
    private String userName="";

    @Column(nullable = false)
    private String name="";

    @Column(nullable = false)
    private String adresse="";



    @Column(nullable = false)
    private int etat=0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date = new Date();

    @Column(nullable = false)
    private double totalPrice = 0;

    public Commande(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }


    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
