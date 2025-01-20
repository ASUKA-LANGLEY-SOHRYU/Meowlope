package com.prosvirnin.authservice.repository;

import com.prosvirnin.authservice.model.domain.user.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);
    Optional<AuthUser> findByEmail(String email);
}
