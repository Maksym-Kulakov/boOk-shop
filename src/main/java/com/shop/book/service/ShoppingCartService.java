package com.shop.book.service;

import com.shop.book.model.ShoppingCart;
import com.shop.book.model.User;

public interface ShoppingCartService {
    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);

    void addBooksToCart(ShoppingCart shoppingCart);
}
