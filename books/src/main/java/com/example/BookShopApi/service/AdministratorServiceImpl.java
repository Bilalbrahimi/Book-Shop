package com.example.BookShopApi.service;

import com.example.BookShopApi.bo.Administrator;
import com.example.BookShopApi.repository.AdministratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public AdministratorServiceImpl( AdministratorRepository admin){
        this.administratorRepository=admin;
    }

    @Override
    public Iterable<Administrator> getListeAdmins() {
        return this.administratorRepository.findAll();
    }

    @Override
    public Administrator getAdmin(int id) {
        return this.administratorRepository.findById(id).orElse(null);
    }

    @Override
    public Administrator createAdmin(Administrator admin) {
        this.administratorRepository.save(admin);
        return admin;
    }

    @Override
    public void deleteAdmin(int id) {
        this.administratorRepository.deleteById(id);
    }

    @Override
    public void updateAdmin(Administrator admin) {
        this.administratorRepository.save(admin);
    }
}
