package com.example.social_media.service;


import com.example.social_media.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    void save(Users users);

    Iterable<Users> findAll();

    Users findByUsername(String username);

    Users getCurrentUser();

    Optional<Users> findById(Long id);

    UserDetails loadUserById(Long id);

    boolean checkLogin(Users users);

    boolean isRegister(Users users);

    boolean isCorrectConfirmPassword(Users users);
}
