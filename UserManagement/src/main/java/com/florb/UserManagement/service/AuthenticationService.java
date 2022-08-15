package com.florb.UserManagement.service;

import com.florb.UserManagement.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
