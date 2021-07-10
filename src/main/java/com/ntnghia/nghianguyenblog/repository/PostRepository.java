package com.ntnghia.nghianguyenblog.repository;

import com.ntnghia.nghianguyenblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTitleContainsOrContentContains(String title, String content);
}
