package com.apiRegion.springjwt.controllers;

import com.apiRegion.springjwt.models.User;
import com.apiRegion.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/User",name ="Users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("nbreUser")
    public int nbreUser(){
        return this.userRepository.findAll().size();
    }
    @GetMapping("lesUser")
    public List<User> lesUtilisateurs(){
        return this.userRepository.lesUsers();
    }


}
