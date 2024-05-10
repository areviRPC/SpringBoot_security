package com.riwi.beautySalon.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 9 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResp { 
    private String message;
    private String token;
}
