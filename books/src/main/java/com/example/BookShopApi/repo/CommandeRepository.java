package com.example.BookShopApi.repo;

import com.example.BookShopApi.model.Commande;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
