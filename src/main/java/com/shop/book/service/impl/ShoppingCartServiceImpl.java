package com.shop.book.service.impl;

import com.shop.book.model.Book;
import com.shop.book.model.ShoppingCart;
import com.shop.book.model.User;
import com.shop.book.repository.ShoppingCartRepository;
import com.shop.book.repository.UserRepository;
import com.shop.book.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository repository, UserRepository userRepository) {
        this.shoppingCartRepository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.findByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
        user.setShoppingCart(shoppingCart);
        userRepository.save(user);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getBooks().clear();
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addBooksToCart(Book book, User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        shoppingCart.getBooks().add(book);
        shoppingCartRepository.save(shoppingCart);
    }
}
