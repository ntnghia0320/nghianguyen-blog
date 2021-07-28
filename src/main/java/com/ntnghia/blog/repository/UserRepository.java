package com.ntnghia.blog.repository;

import com.ntnghia.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstNameContainsOrLastNameContainsOrEmailContains(String firstName, String lastName, String email);

    User findByEmail(String email);
}
