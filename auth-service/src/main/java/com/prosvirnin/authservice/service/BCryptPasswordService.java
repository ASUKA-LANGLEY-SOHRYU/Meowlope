package com.prosvirnin.authservice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPasswordService implements PasswordService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String hashPassword(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}
