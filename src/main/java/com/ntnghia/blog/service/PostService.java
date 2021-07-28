package com.ntnghia.blog.service;

import com.ntnghia.blog.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();

    List<Post> getActivePost();

    Post findById(int id);

    List<Post> findByCategoryId(int id);

    List<Post> findByUserId(int id);

    List<Post> findByKeyword(String keyword);

    Post savePost(Post post, int userId, int categoryId);

    Post updatePost(int id, Post post);

    void deletePost(int id);
}
