package com.riwi.beautySalon.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.LoginReq;
import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.domain.entities.User;
import com.riwi.beautySalon.domain.repositories.UseRepository;
import com.riwi.beautySalon.infraestructure.abstract_service.IAuthService;
import com.riwi.beautySalon.infraestructure.helpers.JwtService;
import com.riwi.beautySalon.utils.enums.Role;
import com.riwi.beautySalon.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

// 10

@AllArgsConstructor
@Service
public class AuthService implements IAuthService{

    @Autowired
    private final UseRepository useRepository;
    @Autowired
    private final JwtService jdJwtService;

    @Override
    public AuthResp login(LoginReq request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    // 10.2
    // registrar el usuario
    @Override
    public AuthResp register(RegisterReq request){
        User exist = this.findUser(request.getUserName());

        if(exist != null){
            throw new BadRequestException("El usuauri ya exuste");
        }

        User user = User.builder()
                    .userName(request.getUserName())
                    .password(request.getPassword())
                    .role(Role.CLIENT)
                    .build();

        user = this.useRepository.save(user);

        return AuthResp.builder()
            .message("Registro exitoso")
            .token(this.jdJwtService.getToken(user))
            .build();

    }

    //10.1
    // Encontrar usuario
    private User findUser(String username){
        return this.useRepository.findByUserName(username).orElse(null);
    }
    
}
