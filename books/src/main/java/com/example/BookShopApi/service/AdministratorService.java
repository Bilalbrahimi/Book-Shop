package com.example.BookShopApi.service;

import com.example.BookShopApi.bo.Administrator;
import com.example.BookShopApi.bo.Customer;

public interface AdministratorService {

    Iterable<Administrator> getListeAdmins();
    Administrator getAdmin(int id);
    Administrator createAdmin(Administrator admin);
    void deleteAdmin(int id);
    void updateAdmin(Administrator admin);
}
