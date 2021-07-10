package com.ntnghia.nghianguyenblog.service;

import com.ntnghia.nghianguyenblog.entity.Post;
import com.ntnghia.nghianguyenblog.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role findById(int id);

    List<Role> findByName(String name);

    Role saveRole(Role role);

    Role updateRole(int id, Role role);

    void deleteRole(int id);
}
