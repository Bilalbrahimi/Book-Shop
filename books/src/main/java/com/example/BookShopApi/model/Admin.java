package com.example.BookShopApi.model;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 35)
    private String adminName;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 128)
    private String address;

    @Column(nullable = false, length = 15)
    private String phone;
}
