/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.controller;

import com.example.gameshop.entity.User;
import com.example.gameshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.example.gameshop.securingweb.UserRole.*;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author sidad
 */
@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "create")
    public User createUser(@RequestBody User user) {

        user.setRole(CUSTOMER);

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

}
