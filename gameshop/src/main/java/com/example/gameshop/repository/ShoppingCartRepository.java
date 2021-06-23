/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.repository;


import com.example.gameshop.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sidad
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
    
}
