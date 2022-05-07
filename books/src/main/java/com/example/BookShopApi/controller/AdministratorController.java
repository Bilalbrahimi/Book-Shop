package com.example.BookShopApi.controller;

import com.example.BookShopApi.bo.Administrator;
import com.example.BookShopApi.bo.Customer;
import com.example.BookShopApi.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class AdministratorController {

    @Autowired
    private final AdministratorService administratorService;


    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }


    @GetMapping(value="/all")
    Iterable<Administrator> getAllAdmins(){
        return this.administratorService.getListeAdmins();
    }

    @GetMapping(value="/id/{id}")
    Administrator getAdmin(@PathVariable int id){
        return this.administratorService.getAdmin(id);
    }


    @PostMapping(value = "/add/",consumes = "application/json")
    Administrator addAdmin(@RequestBody Administrator admin){
        return administratorService.createAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    void deleteAdmin(@PathVariable int id){
        administratorService.deleteAdmin(id);
    }

    @PutMapping("/edit/")
    void modifierAdmin(@RequestBody Administrator admin){
        this.administratorService.updateAdmin(admin);
    }

}
