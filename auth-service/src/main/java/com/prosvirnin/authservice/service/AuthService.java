package com.prosvirnin.authservice.service;

import com.prosvirnin.authservice.model.domain.jwt.RefreshToken;
import com.prosvirnin.authservice.model.domain.jwt.TokenPair;
import com.prosvirnin.authservice.model.dto.LoginRequest;
import com.prosvirnin.authservice.model.dto.RegistrationRequest;

public interface AuthService {
    TokenPair register(RegistrationRequest registrationRequest);

    TokenPair login(LoginRequest loginRequest);

    TokenPair obtainTokenPair(RefreshToken refreshToken);
}
