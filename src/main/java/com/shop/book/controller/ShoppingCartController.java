package com.shop.book.controller;

import com.shop.book.model.Book;
import com.shop.book.model.ShoppingCart;
import com.shop.book.model.User;
import com.shop.book.model.dto.mapper.impl.ShoppingCartMapper;
import com.shop.book.repository.UserRepository;
import com.shop.book.service.BookService;
import com.shop.book.service.ShoppingCartService;

import com.shop.book.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping_carts")
public class ShoppingCartController {
    private final ShoppingCartMapper cartMapper;
    private final ShoppingCartService cartService;
    private final BookService bookService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartMapper cartMapper,
                                  ShoppingCartService cartService, BookService bookService, UserService userService, UserRepository userRepository) {
        this.cartMapper = cartMapper;
        this.cartService = cartService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PutMapping("/books/{bookId}")
    public void create(@PathVariable Long bookId,
                       @RequestParam String email) {
        Book book = bookService.get(bookId);
        User user = userService.getByEmail(email);
        cartService.addBooksToCart(book, user);
    }

    @GetMapping("/reg")
    public void register(@RequestParam String email) {
        User user = userService.getByEmail(email);
        cartService.registerNewShoppingCart(user);
    }


}
