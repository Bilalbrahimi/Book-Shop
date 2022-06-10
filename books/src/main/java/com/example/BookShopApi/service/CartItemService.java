package com.example.BookShopApi.service;

import com.example.BookShopApi.exceptions.CartItemAlreadyExistsException;
import com.example.BookShopApi.exceptions.CartItemDoesNotExistsException;
import com.example.BookShopApi.model.cart.CartItem;
import com.example.BookShopApi.repo.CartItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartItemService {
    private CartItemRepository repo;

    public CartItemService (CartItemRepository repo) {
        this.repo = repo;
    }

    public List<CartItem> getCartItems () {
        return repo.findAll();
    }

    public CartItem getCartItem (Long userId, Long bookId) {
        for (CartItem item : getCartItems()) {
            if (item.getPk().getUser().getId() == userId && item.getPk().getBook().getId() == bookId) {
                return item;
            }
        }

        throw new CartItemDoesNotExistsException(
                "Cart item w/ user id " + userId + " and book id " + bookId + " does not exist."
        );
    }

    public CartItem addCartItem(CartItem cartItem) {
        for (CartItem item : getCartItems()) {
            if (item.equals(cartItem)) {
                throw new CartItemAlreadyExistsException(
                        "Cart item w/ user id " + cartItem.getPk().getUser().getId() + " and book id " +
                                cartItem.getBook().getId() + " already exists."
                );
            }
        }

        return this.repo.save(cartItem);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        for (CartItem item : getCartItems()) {
            if (item.equals(cartItem)) {
                item.setQuantity(cartItem.getQuantity());
                return repo.save(item);
            }
        }

        throw new CartItemDoesNotExistsException(
                "Cart item w/ user id " + cartItem.getPk().getUser().getId() + " and book id " +
                        cartItem.getBook().getId() + " does not exist."
        );
    }

    public void deleteCartItem (Long userId, Long bookId) {
        for (CartItem item : getCartItems()) {
            if (item.getPk().getUser().getId() == userId && item.getPk().getBook().getId() == bookId) {
                repo.delete(item);
                return;
            }
        }

        throw new CartItemDoesNotExistsException(
                "Cart item w/ user id " + userId + " and book id " + bookId + " does not exist."
        );
    }
}

