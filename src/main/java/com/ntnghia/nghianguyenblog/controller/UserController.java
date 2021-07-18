package com.ntnghia.nghianguyenblog.controller;

import com.ntnghia.nghianguyenblog.entity.User;
import com.ntnghia.nghianguyenblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/search", params = "keyword")
    public List<User> getByKeyword(@RequestParam("keyword") String keyword) {
        return userService.findByKeyword(keyword);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public User put(@PathVariable int id, @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
