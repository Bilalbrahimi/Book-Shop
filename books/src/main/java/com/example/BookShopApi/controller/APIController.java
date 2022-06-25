package com.example.BookShopApi.controller;

import com.example.BookShopApi.config.JwtUtil;
import com.example.BookShopApi.model.Book;
import com.example.BookShopApi.model.Commande;
import com.example.BookShopApi.model.User;
import com.example.BookShopApi.model.cart.CartItem;
import com.example.BookShopApi.model.cart.CartItemPK;
import com.example.BookShopApi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class APIController {
    private final UserService userService;
    private final BookService bookService;
    private final CartItemService cartItemService;
    private final CommandeService commandeService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    public APIController(UserService userService, BookService bookService, CartItemService cartItemService,CommandeService commandeService) {
        this.userService = userService;
        this.bookService = bookService;
        this.cartItemService = cartItemService;
        this.commandeService = commandeService;
    }

    @PostMapping("/create-token")
    public ResponseEntity<?> createToken (@RequestBody Map<String, String> user) throws Exception {
        Map<String, Object> tokenResponse = new HashMap<>();
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.get("username"));
        final String token = jwtUtil.generateToken(userDetails);

        tokenResponse.put("token", token);
        return ResponseEntity.ok(tokenResponse);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser (@PathVariable("id") Long id, @RequestBody Map<String, Object> user) {
        User newUser = new User(
                (String) user.get("username"),
                (String) user.get("password"),
                (String) user.get("email"),
                (String) user.get("name"),
                (String) user.get("address"),
                (String) user.get("phone")
        );

        return new ResponseEntity<>(userService.updateUser(id, newUser), HttpStatus.OK);
    }

    @GetMapping("/users/{id}/cart")
    public ResponseEntity<List<CartItem>> getUserCart (@PathVariable("id") Long id) {
        System.out.println(userService.getUser(id).getCartItems().size());
        return new ResponseEntity<>(userService.getUser(id).getCartItems(), HttpStatus.OK);
    }

    @PostMapping("/users/{id}/cart/add/{bookId}")
    public ResponseEntity<User> addToUserCart (@PathVariable("id") Long id,
                                               @PathVariable("bookId") Long bookId) {
        User user = userService.getUser(id);
        Book book = bookService.getBook(bookId);

        CartItem cartItem = new CartItem(user, book, 1);
        cartItemService.addCartItem(cartItem);

        return new ResponseEntity<>(userService.getUser(id), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}/cart/update/{bookId}")
    public ResponseEntity<User> updateCartItem (@PathVariable("id") Long id,
                                                @PathVariable("bookId") Long bookId,
                                                @RequestBody CartItem cartItem) {
        User user = userService.getUser(id);
        Book book = bookService.getBook(bookId);

        cartItem.setPk(new CartItemPK(user, book));
        cartItemService.updateCartItem(cartItem);

        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/cart/remove/{bookId}")
    public ResponseEntity<User> removeFromUserCart (@PathVariable("id") Long id,
                                                    @PathVariable("bookId") Long bookId) {
        cartItemService.deleteCartItem(id, bookId);

        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks () {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook (@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook (@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable("id") Long id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook (@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cart-items")
    public ResponseEntity<List<CartItem>> getCartItems () {
        return ResponseEntity.ok(cartItemService.getCartItems());
    }

    @CrossOrigin
    @GetMapping("/cart-items/{id}/{bookId}")
    public ResponseEntity<CartItem> getCartItem (@PathVariable("id") Long id,
                                                 @PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok(cartItemService.getCartItem(id, bookId));
    }


    @GetMapping(value="/commande/all")
    Iterable<Commande> getAllCommandes(){
        return this.commandeService.getListeCommandes();
    }

    @GetMapping(value="/commande/id/{id}")
    Commande getCommande(@PathVariable int id){
        return this.commandeService.getCommande(id);
    }

    @PostMapping(value = "/commande")
    Commande addCommande(@RequestBody Commande commande){
        return commandeService.createCommande(commande);
    }

    @DeleteMapping("/commande/delete/{id}")
    void deleteOrder(@PathVariable int id){
        commandeService.deleteCommande(id);
    }

    @PutMapping("/commande/edit")
    void modifierCommande(@RequestBody Commande commande){
        this.commandeService.updateCommande(commande);
    }
}
