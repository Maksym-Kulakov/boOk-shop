package com.shop.book.service.impl;

import com.shop.book.model.Order;
import com.shop.book.model.ShoppingCart;
import com.shop.book.model.User;
import com.shop.book.repository.BookRepository;
import com.shop.book.repository.OrderRepository;
import com.shop.book.service.OrderService;
import com.shop.book.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final BookRepository bookRepository;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderRepository repository,
                            BookRepository bookRepository,
                            ShoppingCartService shoppingCartService) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setUser(shoppingCart.getUser());
        order.setBooks(shoppingCart.getBooks());
        repository.save(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return null;
    }
}
