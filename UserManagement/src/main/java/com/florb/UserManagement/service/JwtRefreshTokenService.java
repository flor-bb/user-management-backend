package com.florb.UserManagement.service;

import com.florb.UserManagement.model.JwtRefreshToken;
import com.florb.UserManagement.model.User;

public interface JwtRefreshTokenService {
    JwtRefreshToken createRefreshToken(Long userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
