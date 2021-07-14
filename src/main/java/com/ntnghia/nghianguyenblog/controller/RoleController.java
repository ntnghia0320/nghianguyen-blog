package com.ntnghia.nghianguyenblog.controller;

import com.ntnghia.nghianguyenblog.entity.Role;
import com.ntnghia.nghianguyenblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable int id) {
        return roleService.findById(id);
    }

    @GetMapping("/search")
    public List<Role> getByName(@RequestParam String name) {
        return roleService.findByName(name);
    }
}
