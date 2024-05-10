package com.riwi.beautySalon.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.infraestructure.services.AuthService;



// 2
@RestController
@RequestMapping
public class AuthController {

    @Autowired AuthService authService;
    
    // 2.1
    @PostMapping(path = "/auth/login")
    public String login(){
        return "Desde login";
    }

    // 2.2
    @PostMapping(path = "/auth/registrer")
    public ResponseEntity<AuthResp> register( // 12 
        @Validated @RequestBody RegisterReq request
    ){
        return ResponseEntity.ok(this.authService.register(request));
    }
    


}
