package com.shop.book.service;

import com.shop.book.model.User;
import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> getByEmail(String email);
}

