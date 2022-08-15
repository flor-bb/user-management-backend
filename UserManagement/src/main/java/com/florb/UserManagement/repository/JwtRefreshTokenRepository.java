package com.florb.UserManagement.repository;

import com.florb.UserManagement.model.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {



}
