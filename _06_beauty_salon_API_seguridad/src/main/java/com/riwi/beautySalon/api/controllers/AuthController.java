package com.riwi.beautySalon.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 2
@RestController
@RequestMapping
public class AuthController {
    
    // 2.1
    @PostMapping(path = "/auth/login")
    public String login(){
        return "Desde login";
    }

    // 2.2
    @PostMapping(path = "/auth/registrer")
    public String registrer(){
        return "registro";
    }
}
