package com.florb.UserManagement.controller;


import com.florb.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Give access to endpoints
@RequestMapping("api/admin")//pre-path
public class AdminController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("all")//api/admin/all
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

}
