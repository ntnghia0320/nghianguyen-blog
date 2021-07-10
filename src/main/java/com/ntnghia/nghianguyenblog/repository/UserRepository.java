package com.ntnghia.nghianguyenblog.repository;

import com.ntnghia.nghianguyenblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);
    List<User> findByEmailContains(String email);
    User findByEmail(String email);
}
