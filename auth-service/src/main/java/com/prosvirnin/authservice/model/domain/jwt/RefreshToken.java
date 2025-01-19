package com.prosvirnin.authservice.model.domain.jwt;

import lombok.Data;

@Data
public class RefreshToken implements Token {
    private String token;

    private RefreshToken(String token) {
        this.token = token;
    }

    public static RefreshToken of(String token) {
        return new RefreshToken(token);
    }
}
