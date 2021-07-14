package com.ntnghia.nghianguyenblog.service;

import com.ntnghia.nghianguyenblog.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(int id);

    List<User> findByName(String name);

    List<User> findByEmail(String email);

    User saveUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);
}
