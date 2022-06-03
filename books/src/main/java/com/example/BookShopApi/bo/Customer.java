package com.example.BookShopApi.bo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer {

    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int customerID;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String emailAddress;

    @NonNull
    private String address;

    @NonNull
    private String city;

    @NonNull
    private String zipCode;

    private String phoneNumber;

    @NonNull
    private String encryptedPassword;

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    @NonNull
    private boolean connected;



    @ElementCollection(targetClass=Order.class)
    @JsonIgnoreProperties({ "customer" })
    @OneToMany(mappedBy="customer",cascade = CascadeType.ALL)//cascade = CascadeType.REMOVE)
    private List<Order> orders = new ArrayList<>();



    public List<Order> getOrders() {
        return orders;
    }

    public void setOrder(Order order) {
        this.orders.add(order);
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(@NonNull int customerID) {
        this.customerID = customerID;
    }


}