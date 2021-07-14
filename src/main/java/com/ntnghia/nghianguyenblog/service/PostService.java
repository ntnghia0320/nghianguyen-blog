package com.ntnghia.nghianguyenblog.service;

import com.ntnghia.nghianguyenblog.entity.Post;

import java.text.ParseException;
import java.util.List;

public interface PostService {
    List<Post> getAll();

    Post findById(int id);

    List<Post> findByCategoryId(int id);

    List<Post> findByKeyword(String keyword);

    Post savePost(Post post, int userId, int categoryId);

    Post updatePost(int id, Post post);

    void deletePost(int id);
}
