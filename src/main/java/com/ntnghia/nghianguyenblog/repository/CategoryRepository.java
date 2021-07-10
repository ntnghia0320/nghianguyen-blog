package com.ntnghia.nghianguyenblog.repository;

import com.ntnghia.nghianguyenblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByNameContains(String name);

    Category findOneByName(String name);
}
