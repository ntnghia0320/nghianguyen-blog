package com.ntnghia.nghianguyenblog.controller;

import javax.validation.Valid;

import com.ntnghia.nghianguyenblog.entity.User;
import com.ntnghia.nghianguyenblog.payload.request.LoginRequest;
import com.ntnghia.nghianguyenblog.payload.respose.JwtResponse;
import com.ntnghia.nghianguyenblog.security.service.AuthService;
import com.ntnghia.nghianguyenblog.service.UserService;
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
