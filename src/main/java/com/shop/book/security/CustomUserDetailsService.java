package com.shop.book.security;

import com.shop.book.model.Role;
import com.shop.book.model.User;
import com.shop.book.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email " + email)
        );
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), mapRolesToAuthority(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthority(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
