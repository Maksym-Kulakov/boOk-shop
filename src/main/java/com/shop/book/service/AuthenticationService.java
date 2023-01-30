package com.shop.book.service;

import com.shop.book.model.User;
import com.shop.book.model.dto.user.UserLoginDto;
import com.shop.book.model.dto.user.UserSignUpDto;

public interface AuthenticationService {
    String authenticate(UserLoginDto loginDto);

    User registerUser(UserSignUpDto signUpDto);
}
