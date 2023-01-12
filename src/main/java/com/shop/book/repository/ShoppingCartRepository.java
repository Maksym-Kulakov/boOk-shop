package com.shop.book.repository;

import com.shop.book.model.ShoppingCart;
import com.shop.book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUser(User user);
}
