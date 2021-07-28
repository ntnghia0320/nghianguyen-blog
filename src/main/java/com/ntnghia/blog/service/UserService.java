package com.ntnghia.blog.service;

import com.ntnghia.blog.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(int id);

    List<User> findByKeyword(String keyword);

    User saveUser(User user);

    User updateUser(int id, User user);

    User setRoleUser(int id, int roleId);

    void deleteUser(int id);
}
