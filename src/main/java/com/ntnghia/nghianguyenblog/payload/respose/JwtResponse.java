package com.ntnghia.nghianguyenblog.payload.respose;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String role;

    public JwtResponse(String jwt, String username, String role) {
        this.token = jwt;
        this.username = username;
        this.role = role;
    }
}
