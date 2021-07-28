package com.ntnghia.blog.repository;

import com.ntnghia.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTitleContainsOrContentContains(String title, String content);

    List<Post> findByCategoryIdAndIsActive(int id, boolean isActive);

    List<Post> findByUserId(int id);

    List<Post> findByIsActive(boolean isActive);
}
