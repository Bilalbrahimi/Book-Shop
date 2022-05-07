package com.example.BookShopApi.bo;

import org.springframework.lang.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Administrator {
    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int AdminID;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String emailAddress;

    @NonNull
    private String encryptedPassword;
}
