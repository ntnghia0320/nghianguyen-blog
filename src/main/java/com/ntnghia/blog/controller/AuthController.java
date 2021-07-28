package com.ntnghia.blog.controller;

import javax.validation.Valid;

import com.ntnghia.blog.entity.User;
import com.ntnghia.blog.payload.request.LoginRequest;
import com.ntnghia.blog.payload.respose.JwtResponse;
import com.ntnghia.blog.security.service.AuthService;
import com.ntnghia.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public JwtResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authUser(loginRequest);
    }

    @PostMapping("/register")
    public User registerUserRoleUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }
}
