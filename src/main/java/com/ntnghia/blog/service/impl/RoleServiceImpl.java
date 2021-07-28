package com.ntnghia.blog.service.impl;

import com.ntnghia.blog.entity.Role;
import com.ntnghia.blog.exception.BadRequestException;
import com.ntnghia.blog.exception.NotFoundException;
import com.ntnghia.blog.repository.RoleRepository;
import com.ntnghia.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        if (isIdExist(id)) return roleRepository.findById(id).get();

        throw new NotFoundException(String.format("Role id %d not found", id));
    }

    @Override
    public List<Role> findByName(String name) {
        return roleRepository.findByNameContains(name);
    }

    @Override
    public Role saveRole(Role role) {
        if (!isRoleNameExist(role.getName())) {
            return roleRepository.save(role);
        }

        throw new BadRequestException("Role is exist");
    }

    @Override
    public Role updateRole(int id, Role role) {
        if (isIdExist(id)) {
            Role roleOld = roleRepository.findById(id).get();

            if (roleOld.getName().equals(role.getName())) {
                throw new BadRequestException("Role not change");
            } else if (isRoleNameExist(role.getName())) {
                throw new BadRequestException("Role duplicate");
            } else {
                role.setId(id);

                return roleRepository.save(role);
            }
        }

        throw new NotFoundException(String.format("Role id %d not found", id));
    }

    @Override
    public void deleteRole(int id) {
        if (isIdExist(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("Role id %d not found", id));
        }
    }

    private boolean isRoleNameExist(String name) {
        return roleRepository.findByName(name) != null;
    }

    private boolean isIdExist(int id) {
        return roleRepository.existsById(id);
    }
}
