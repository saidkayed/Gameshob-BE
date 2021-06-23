/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.securingweb;

import com.google.common.collect.Sets;
import java.util.Set;
import static com.example.gameshop.securingweb.UserPermission.*;
/**
 *
 * @author sidad
 */
public enum UserRole {
    CUSTOMER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            CART_READ,
            CART_WRITE,
            GAMEITEM_READ,
            GAMEITEM_WRITE
    ));
    
    
    
    private final Set<UserPermission> permissions;

    private UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

   
    
    
}
