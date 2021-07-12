package com.ntnghia.nghianguyenblog.service.impl;

import com.ntnghia.nghianguyenblog.entity.User;
import com.ntnghia.nghianguyenblog.exception.BadRequestException;
import com.ntnghia.nghianguyenblog.exception.NotFoundException;
import com.ntnghia.nghianguyenblog.repository.RoleRepository;
import com.ntnghia.nghianguyenblog.repository.UserRepository;
import com.ntnghia.nghianguyenblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        if (isIdExist(id)) return userRepository.findById(id).get();

        throw new NotFoundException(String.format("User id %d not found", id));
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByFirstNameContainsOrLastNameContains(name, name);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmailContains(email);
    }

    @Override
    public User saveUserRoleUser(User user) {
        if (isEmailExist(user.getEmail())) {
            throw new BadRequestException("User email exist");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByName("ROLE_USER"));

        return userRepository.save(user);
    }

    @Override
    public User saveUserRoleAdmin(User user) {
        if (isEmailExist(user.getEmail())) {
            throw new BadRequestException("User email exist");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByName("ROLE_ADMIN"));

        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        if (isIdExist(id)) {
            User userOld = userRepository.findById(id).get();

            if (isUserExist(userOld, user)) {
                throw new BadRequestException("User not change");
            } else if (isEmailExist(user.getEmail())) {
                throw new BadRequestException("Email user duplicate");
            } else {
                user.setId(id);
                user.setRole(userOld.getRole());

                return userRepository.save(user);
            }
        }

        throw new NotFoundException(String.format("User id %d not found", id));
    }

    @Override
    public void deleteUser(int id) {
        if (isIdExist(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("User id %d not found", id));
        }
    }

    private boolean isIdExist(int id) {
        return userRepository.existsById(id);
    }

    private boolean isUserExist(User userOld, User userNew) {
        return userOld.getEmail().equals(userNew.getEmail())
                && userOld.getFirstName().equals(userNew.getFirstName())
                && userOld.getLastName().equals(userNew.getLastName())
                && userOld.getPassword().equals(userNew.getPassword());
    }

    private boolean isEmailExist(String email){
        return userRepository.findByEmail(email) != null;
    }
}
