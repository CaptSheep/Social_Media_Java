package com.example.social_media.service.impl;


import com.example.social_media.model.Users;
import com.example.social_media.model.UserPrinciple;
import com.example.social_media.repository.UserRepository;
import com.example.social_media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(username);
        }
        if (this.checkLogin(users)) {
            return UserPrinciple.build(users);
        }
        boolean enable = false;
        boolean accountNonExpired = false;
        boolean credentialsNonExpired = false;
        boolean accountNonLocked = false;
        return new org.springframework.security.core.userdetails.User(users.getUsername(),
                users.getPassword(), enable, accountNonExpired, credentialsNonExpired,
                accountNonLocked, null);
    }


    @Override
    public void save(Users users) {
        userRepository.save(users);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users getCurrentUser() {
        Users users;
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        users = this.findByUsername(userName);
        return users;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NullPointerException();
        }
        return UserPrinciple.build(user.get());
    }

    @Override
    public boolean checkLogin(Users user) {
        Iterable<Users> users = this.findAll();
        boolean isCorrectUser = false;
        for (Users currentUsers : users) {
            if (currentUsers.getUsername().equals(user.getUsername()) && user.getPassword().equals(currentUsers.getPassword()) && currentUsers.isEnabled()) {
                isCorrectUser = true;
                break;
            }
        }
        return isCorrectUser;
    }

    @Override
    public boolean isRegister(Users user) {
        boolean isRegister = false;
        Iterable<Users> users = this.findAll();
        for (Users currentUsers : users) {
            if (user.getUsername().equals(currentUsers.getUsername())) {
                isRegister = true;
                break;
            }
        }
        return isRegister;
    }

    @Override
    public boolean isCorrectConfirmPassword(Users users) {
        return users.getPassword().equals(users.getConfirmPassword());
    }
}
