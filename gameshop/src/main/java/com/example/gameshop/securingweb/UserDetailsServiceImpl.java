/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.securingweb;

import com.example.gameshop.entity.User;
import com.example.gameshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author sidad
 */
public class UserDetailsServiceImpl implements UserDetailsService{

    
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userRepository.getUserByUsername(username);
        
        if(user == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        
        return new MyUserDetails(user);
    }
    
}
