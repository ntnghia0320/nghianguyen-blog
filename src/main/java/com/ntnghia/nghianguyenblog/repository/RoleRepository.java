package com.ntnghia.nghianguyenblog.repository;

import com.ntnghia.nghianguyenblog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
    List<Role> findByNameContains(String name);
}
