package com.shop.book.service.impl;

import com.shop.book.model.User;
import com.shop.book.repository.UserRepository;
import com.shop.book.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User create(User user) {
        return userRepository.save(user);
    }
}
