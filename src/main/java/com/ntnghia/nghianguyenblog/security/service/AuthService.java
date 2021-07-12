package com.ntnghia.nghianguyenblog.security.service;

import com.ntnghia.nghianguyenblog.payload.request.LoginRequest;
import com.ntnghia.nghianguyenblog.payload.respose.JwtResponse;

public interface AuthService {
    JwtResponse authUser(LoginRequest loginRequest);
}
