package com.prosvirnin.authservice.model.domain.jwt;

import lombok.Data;

@Data
public class AccessToken implements Token {
    private String token;

    private AccessToken(String token) {
        this.token = token;
    }

    public static AccessToken of(String token) {
        return new AccessToken(token);
    }
}
