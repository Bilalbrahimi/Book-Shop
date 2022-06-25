package com.example.BookShopApi.service;

import com.example.BookShopApi.exceptions.CartItemAlreadyExistsException;
import com.example.BookShopApi.exceptions.CartItemDoesNotExistsException;
import com.example.BookShopApi.model.Commande;
import com.example.BookShopApi.model.cart.CartItem;
import com.example.BookShopApi.repo.CartItemRepository;
import com.example.BookShopApi.repo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository){
        this.commandeRepository=commandeRepository;
    }



    public Iterable<Commande> getListeCommandes() {
        return this.commandeRepository.findAll();
    }


    public Commande getCommande(int id) {
        return this.commandeRepository.findById(id).orElse(null);
    }


    public Commande createCommande(Commande commande) {
        this.commandeRepository.save(commande);
        return commande;
    }


    public void deleteCommande(int id) {
        this.commandeRepository.deleteById(id);
    }


    public void updateCommande(Commande commande) {
        this.commandeRepository.save(commande);
    }


}
