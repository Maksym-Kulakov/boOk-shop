package com.shop.book.service;

import com.shop.book.model.Order;
import com.shop.book.model.ShoppingCart;
import com.shop.book.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrderHistory(User user);
}
