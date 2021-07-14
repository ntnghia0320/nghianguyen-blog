package com.ntnghia.nghianguyenblog.payload.respose;

import lombok.Data;

@Data
public class JwtResponse {
    private int idUser;
    private String token;
    private String type = "Bearer";
    private String username;
    private String role;

    public JwtResponse(int idUser, String jwt, String username, String role) {
        this.idUser = idUser;
        this.token = jwt;
        this.username = username;
        this.role = role;
    }
}
