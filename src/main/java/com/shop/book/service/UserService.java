package com.shop.book.service;

import com.shop.book.model.User;

public interface UserService {
    User create(User user);

    User getByEmail(String email);
}

