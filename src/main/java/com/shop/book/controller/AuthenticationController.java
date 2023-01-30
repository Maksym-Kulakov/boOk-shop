package com.shop.book.controller;

import com.shop.book.config.SecurityConfig;
import com.shop.book.model.dto.user.UserLoginDto;
import com.shop.book.model.dto.user.UserSignUpDto;
import com.shop.book.repository.UserRepository;
import com.shop.book.security.jwt.JwtAuthResponse;
import com.shop.book.service.AuthenticationService;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Import(SecurityConfig.class)
@RestController
@RequestMapping("/login")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/in")
    public ResponseEntity<JwtAuthResponse> authenticate(
            @RequestBody UserLoginDto loginDto) {
        String token = authenticationService.authenticate(loginDto);
        return ResponseEntity.ok(new JwtAuthResponse(token));
    }

    @PostMapping("/up")
    public ResponseEntity<String> registerUser(@RequestBody UserSignUpDto signUpDto) {
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByPhone(signUpDto.getPhone())) {
            return new ResponseEntity<>("Phone is already taken!", HttpStatus.BAD_REQUEST);
        }
        authenticationService.registerUser(signUpDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
