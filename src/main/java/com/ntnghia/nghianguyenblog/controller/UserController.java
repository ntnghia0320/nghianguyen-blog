package com.ntnghia.nghianguyenblog.controller;

import com.ntnghia.nghianguyenblog.entity.User;
import com.ntnghia.nghianguyenblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blog/users")
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

    @GetMapping(value = "/search", params="name")
    public List<User> getByName(@RequestParam("name") String name) {
        return userService.findByName(name);
    }

    @GetMapping(value = "/search", params="email")
    public List<User> getByEmail(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/save-user")
    public User postSaveUser(@Valid @RequestBody User user) {
        return userService.saveUserRoleUser(user);
    }

    @PostMapping("/save-admin")
    public User postSaveAdmin(@Valid @RequestBody User user) {
        return userService.saveUserRoleAdmin(user);
    }

    @PutMapping("/{id}")
    public User put(@PathVariable int id, @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
