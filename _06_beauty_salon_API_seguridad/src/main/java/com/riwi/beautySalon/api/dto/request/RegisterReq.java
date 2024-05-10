package com.riwi.beautySalon.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 5
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
    @NotBlank(message = "El usuario es obligatorio") 
    @Size(min = 8 , max = 150, message = "El usuario debe tener minimo 8 caracteres")
    private String userName;
    @NotBlank(message = "La contraseña es obligatoria") 
    @Size(min = 8 , max = 150, message = "El usuario debe tener minimo 8 caracteres")
    private String password;
}