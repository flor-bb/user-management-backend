package com.florb.UserManagement;

import com.florb.UserManagement.model.Role;
import com.florb.UserManagement.model.User;
import com.florb.UserManagement.repository.UserRepository;
import com.florb.UserManagement.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class UserManagementApplication {

    @Autowired
	UserServiceImplementation userServiceImplementation;

	@Autowired
	UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }


    //====================================================
    //Will create an admin account on first startup
    //====================================================
    @PostConstruct
    private void createAdmin() {
        if (userRepository.findAll().size() < 1) {
            User user = new User();
            user.setName("admin");
            user.setUsername("admin");
            user.setPassword("admin");
			user.setCreateTime(LocalDateTime.now());
			userServiceImplementation.saveUser(user);
            userServiceImplementation.changeRole(Role.ADMIN, user.getUsername());
        }
    }

}
