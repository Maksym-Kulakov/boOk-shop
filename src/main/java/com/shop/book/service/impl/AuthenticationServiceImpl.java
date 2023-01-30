package com.shop.book.service.impl;

import com.shop.book.model.Role;
import com.shop.book.model.User;
import com.shop.book.model.dto.user.UserLoginDto;
import com.shop.book.model.dto.user.UserSignUpDto;
import com.shop.book.repository.RoleRepository;
import com.shop.book.repository.UserRepository;
import com.shop.book.security.jwt.JwtTokenProvider;
import com.shop.book.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final ShoppingCartServiceImpl cartService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     UserRepository userRepository,
                                     ShoppingCartServiceImpl cartService,
                                     RoleRepository roleRepository,
                                     PasswordEncoder passwordEncoder,
                                     JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.cartService = cartService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String authenticate(UserLoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),loginDto.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public User registerUser(UserSignUpDto signUpDto) {
        User user = new User();
        user.setName(signUpDto.getFirstName());
        user.setSurname(signUpDto.getLastName());
        user.setEmail(signUpDto.getEmail());
        user.setPhone(signUpDto.getPhone());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role role = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singleton(role));
        user.setRegistrationDateTime(LocalDateTime.now());
        userRepository.save(user);
        cartService.registerNewShoppingCart(user);
        return user;
    }
}
