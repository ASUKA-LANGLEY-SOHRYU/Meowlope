package com.prosvirnin.authservice.service;

public interface PasswordService {
    String hashPassword(String password);

    boolean verifyPassword(String rawPassword, String hashedPassword);
}
