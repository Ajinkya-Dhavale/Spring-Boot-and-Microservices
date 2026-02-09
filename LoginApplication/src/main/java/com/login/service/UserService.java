package com.login.service;

import com.login.dao.UserDAO;
import com.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    // REGISTER
    public void registerUser(User user) {

        // Check duplicate username
        if (dao.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException(
                "Username already exists"
            );
        }

        // Encrypt password
        if (user.getPassword() != null) {
            user.setPassword(
                encoder.encode(user.getPassword())
            );
        }

        // Assign role
        user.setRole("ROLE_USER");

        // Save user
        dao.saveUser(user);
    }

    // FIND USER
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
