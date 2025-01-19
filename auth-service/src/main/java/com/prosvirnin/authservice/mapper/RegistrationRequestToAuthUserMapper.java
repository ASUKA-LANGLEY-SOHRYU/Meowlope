package com.prosvirnin.authservice.mapper;

import com.prosvirnin.authservice.model.domain.user.AuthUser;
import com.prosvirnin.authservice.model.dto.RegistrationRequest;
import org.springframework.stereotype.Component;

@Component
public class RegistrationRequestToAuthUserMapper implements Mapper<RegistrationRequest, AuthUser> {
    @Override
    public AuthUser map(RegistrationRequest registrationRequest) {
        return AuthUser.builder()
                .email(registrationRequest.getEmail())
                .username(registrationRequest.getUsername())
                .password(registrationRequest.getPassword())
                .build();
    }
}
