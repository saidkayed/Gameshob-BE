/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.controller;

import com.example.gameshop.entity.Gameitem;
import com.example.gameshop.repository.GameitemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sidad
 */
@RestController
@RequestMapping(path = "/api/gameitem")
public class GameitemController {

    @Autowired
    GameitemRepository gameItemRepository;

    @GetMapping(path = "all")
    public List<Gameitem> getAllGame() {

        return gameItemRepository.findAll();
    }

}
