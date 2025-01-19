package com.prosvirnin.authservice.model.domain.jwt;

import lombok.Data;

@Data
public class TokenPair {
    private RefreshToken refresh;
    private AccessToken access;

    private TokenPair(RefreshToken refresh, AccessToken access) {
        this.refresh = refresh;
        this.access = access;
    }

    public static TokenPair of(String refreshToken, String accessToken) {
        return new TokenPair(
                RefreshToken.of(refreshToken),
                AccessToken.of(accessToken)
        );
    }
}
