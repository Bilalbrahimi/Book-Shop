package com.example.BookShopApi.repository;

import com.example.BookShopApi.bo.Administrator;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator,Integer> {

}
