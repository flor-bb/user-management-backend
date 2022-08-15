package com.florb.UserManagement.security;

import com.florb.UserManagement.model.User;
import com.florb.UserManagement.service.UserService;
import com.florb.UserManagement.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        return UserPrincipal.builder().
                user(user).
                id(user.getId()).
                username(user.getUsername()).
                password(user.getPassword()).
                authorities(authorities).
                build();
    }
}
