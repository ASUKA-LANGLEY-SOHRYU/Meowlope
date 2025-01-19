package com.prosvirnin.authservice.service;

import com.prosvirnin.authservice.exception.api.IncorrectPasswordException;
import com.prosvirnin.authservice.exception.api.InvalidRefreshTokenException;
import com.prosvirnin.authservice.exception.api.UserAlreadyExistsException;
import com.prosvirnin.authservice.exception.api.UserNotFoundException;
import com.prosvirnin.authservice.mapper.Mapper;
import com.prosvirnin.authservice.model.domain.jwt.RefreshToken;
import com.prosvirnin.authservice.model.domain.jwt.TokenPair;
import com.prosvirnin.authservice.model.domain.user.AuthUser;
import com.prosvirnin.authservice.model.domain.user.Role;
import com.prosvirnin.authservice.model.dto.LoginRequest;
import com.prosvirnin.authservice.model.dto.RegistrationRequest;
import com.prosvirnin.authservice.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DefaultAuthService implements AuthService {

    private final AuthUserRepository authUserRepository;
    private final Mapper<RegistrationRequest, AuthUser> mapper;
    private final PasswordService passwordService;
    private final JWTService jwtService;

    @Override
    public TokenPair register(RegistrationRequest registrationRequest) {
        if (authUserRepository.findByUsername(registrationRequest.getUsername()).isPresent())
            throw new UserAlreadyExistsException(registrationRequest.getUsername());
        AuthUser user = mapper.map(registrationRequest);
        user.setPassword(passwordService.hashPassword(registrationRequest.getPassword()));
        user.setRoles(Set.of(Role.USER));
        authUserRepository.save(user);
        //TODO: оповещение через брокера на другой сервис.
        return jwtService.generateTokenPair(user);
    }

    @Override
    public TokenPair login(LoginRequest loginRequest) {
        AuthUser user = authUserRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException(loginRequest.getUsername()));
        if (!passwordService.verifyPassword(loginRequest.getPassword(), user.getPassword()))
            throw new IncorrectPasswordException();
        return jwtService.generateTokenPair(user);
    }

    @Override
    public TokenPair obtainTokenPair(RefreshToken refreshToken) {
        if (!jwtService.isValid(refreshToken))
            throw new InvalidRefreshTokenException();
        String username = jwtService.getSubject(refreshToken);
        AuthUser user = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        return jwtService.generateTokenPair(user);
    }
}
