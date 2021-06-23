/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.dto;

import com.example.gameshop.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author sidad
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameItemRequest {
    
    private ShoppingCart shoppingcart; 
}
