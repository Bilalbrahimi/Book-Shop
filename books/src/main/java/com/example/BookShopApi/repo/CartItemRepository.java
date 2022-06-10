package com.example.BookShopApi.repo;
import com.example.BookShopApi.model.cart.CartItem;
import com.example.BookShopApi.model.cart.CartItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends JpaRepository <CartItem, CartItemPK> {
}
