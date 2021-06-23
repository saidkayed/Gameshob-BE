/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gameshop.controller;

import com.example.gameshop.entity.Gameitem;
import com.example.gameshop.repository.GameitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(path = "/admin/gameitem")
public class GameitemAdminController {

    @Autowired
    GameitemRepository gameItemRepository;

    @DeleteMapping(path = "delete/{id}")
    public String deleteGame(@PathVariable Integer id) {

        gameItemRepository.deleteById(id);

        return "Game got deleted successfull";

    }

    @PostMapping(path = "add")
    public Gameitem addGame(@RequestBody Gameitem gameitem) {

        return gameItemRepository.save(gameitem);
    }
}
