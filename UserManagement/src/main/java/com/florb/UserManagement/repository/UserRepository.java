package com.florb.UserManagement.repository;

import com.florb.UserManagement.model.Role;
import com.florb.UserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);

    @Modifying
    @Query("update User set role = :role where user_name= :user_name")
    void updateUserRole(@Param("user_name") String user_name, @Param("role") Role role);
}
