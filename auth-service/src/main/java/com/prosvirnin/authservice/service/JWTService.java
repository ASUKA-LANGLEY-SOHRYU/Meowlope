package com.prosvirnin.authservice.service;

import com.prosvirnin.authservice.model.domain.jwt.Token;
import com.prosvirnin.authservice.model.domain.jwt.TokenPair;
import com.prosvirnin.authservice.model.domain.user.AuthUser;

public interface JWTService {
    TokenPair generateTokenPair(AuthUser user);

    boolean isValid(Token token);

    String getSubject(Token token);
}
