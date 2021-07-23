package com.ntnghia.blog.security.service;

import com.ntnghia.blog.payload.request.LoginRequest;
import com.ntnghia.blog.payload.respose.JwtResponse;

public interface AuthService {
    JwtResponse authUser(LoginRequest loginRequest);
}
