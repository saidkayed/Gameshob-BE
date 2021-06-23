/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.securingweb;

/**
 *
 * @author sidad
 */
public enum UserPermission {
    CART_READ("cart:read"),
    CART_WRITE("cart:write"),
    GAMEITEM_WRITE("gameitem:write"),
    GAMEITEM_READ("gameitem:read");
    
    private final String permission;

    private UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
    
    
    
    
}
