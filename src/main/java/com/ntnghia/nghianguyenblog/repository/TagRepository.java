package com.ntnghia.nghianguyenblog.repository;

import com.ntnghia.nghianguyenblog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByName(String name);
}
