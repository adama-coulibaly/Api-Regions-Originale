package com.apiRegion.springjwt.controllers;

import com.apiRegion.springjwt.repository.CommentaireRepository;
import com.apiRegion.springjwt.repository.UserRepository;
import com.apiRegion.springjwt.security.services.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/projet/odk/User",name ="Users")

public class UserController {

    private UserRepository userRepository;

    @GetMapping("nbreUser")
    public int nbreUser(){
        return this.userRepository.lesUsers();
    }


}
