package com.prosvirnin.authservice.controller;

import com.prosvirnin.authservice.model.domain.jwt.RefreshToken;
import com.prosvirnin.authservice.model.domain.jwt.TokenPair;
import com.prosvirnin.authservice.model.dto.LoginRequest;
import com.prosvirnin.authservice.model.dto.RegistrationRequest;
import com.prosvirnin.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenPair> register(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(authService.register(registrationRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenPair> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/obtaintokenpair")
    public ResponseEntity<TokenPair> obtainTokenPair(@RequestBody RefreshToken refreshToken) {
        return ResponseEntity.ok(authService.obtainTokenPair(refreshToken));
    }
}

