/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */        

package com.example.gameshop.controller;


import com.example.gameshop.entity.Gameitem;
import com.example.gameshop.entity.ShoppingCart;
import com.example.gameshop.repository.GameitemRepository;
import com.example.gameshop.repository.ShoppingCartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sidad
 */
@RestController
@RequestMapping(path = "cart")
public class ShoppingCartController {

    
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    
    @Autowired
    GameitemRepository gameitemRepository;
    

    @PostMapping(path = "add")
    public ShoppingCart addToCart(@RequestBody ShoppingCart request) {

        return shoppingCartRepository.save(request);
        
     
    }
    
    @PutMapping(path = "placeitem/{id}")
    public ShoppingCart placeToCart(@RequestBody Gameitem gameitem, @PathVariable Integer id) {
        ShoppingCart shoppingcart = shoppingCartRepository.findById(id).get();

        shoppingcart.addGameItem(gameitem);

        return shoppingCartRepository.save(shoppingcart);

    }
    
    @GetMapping(path = "all")
    public List<ShoppingCart> findAll (){
        return shoppingCartRepository.findAll();
    }


    
}
