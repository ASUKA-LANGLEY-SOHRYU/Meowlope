package com.prosvirnin.authservice.model.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
