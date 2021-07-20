package com.ntnghia.nghianguyenblog.service.impl;

import com.ntnghia.nghianguyenblog.entity.Category;
import com.ntnghia.nghianguyenblog.entity.Post;
import com.ntnghia.nghianguyenblog.entity.Tag;
import com.ntnghia.nghianguyenblog.exception.BadRequestException;
import com.ntnghia.nghianguyenblog.exception.NotFoundException;
import com.ntnghia.nghianguyenblog.repository.CategoryRepository;
import com.ntnghia.nghianguyenblog.repository.PostRepository;
import com.ntnghia.nghianguyenblog.repository.TagRepository;
import com.ntnghia.nghianguyenblog.repository.UserRepository;
import com.ntnghia.nghianguyenblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        if (isIdExist(id)) return postRepository.findById(id).get();

        throw new NotFoundException(String.format("Post id %d not found", id));
    }

    @Override
    public List<Post> findByCategoryId(int id) {
        return postRepository.findByCategoryId(id);
    }

    @Override
    public List<Post> findByUserId(int id) {
        return postRepository.findByUserId(id);
    }

    @Override
    public List<Post> findByKeyword(String keyword) {
        return postRepository.findByTitleContainsOrContentContains(keyword, keyword);
    }

    @Override
    public Post savePost(Post post, int categoryId, int userId) {
        if (userRepository.existsById(userId)) {
            post.setUser(userRepository.findById(userId).get());
        } else {
            throw new BadRequestException("Id user not found");
        }

        if (categoryRepository.existsById(categoryId)) {
            post.setCategory(categoryRepository.findById(categoryId).get());
        } else {
            throw new BadRequestException("Id category not found");
        }

        List<Tag> tagsRequest = post.getTags();
        List<Tag> tagsExist = new ArrayList<>();

        for (Tag tag : tagsRequest) {
            Tag tagTmp = tagRepository.findByName(tag.getName());
            if (tagTmp != null) {
                tagsExist.add(tagTmp);
            } else {
                tagsExist.add(tagRepository.save(tag));
            }
        }

        post.setTags(tagsExist);

        return postRepository.save(post);
    }

    @Override
    public Post updatePost(int id, Post post) {
        Category category = categoryRepository.findOneByName(post.getCategory().getName());

        if (category != null) {
            post.setCategory(category);
        } else {
            throw new BadRequestException("Category name not found");
        }

        List<Tag> tagsRequest = post.getTags();
        List<Tag> tagsExist = new ArrayList<>();

        for (Tag tag : tagsRequest) {
            Tag tagTmp = tagRepository.findByName(tag.getName());
            if (tagTmp != null) {
                tagsExist.add(tagTmp);
            } else {
                tagsExist.add(tagRepository.save(tag));
            }
        }

        post.setId(id);
        post.setTags(tagsExist);

        return postRepository.save(post);
    }

    @Override
    public void deletePost(int id) {
        if (isIdExist(id)) {
            postRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("Post id %d not found", id));
        }

    }

    private boolean isIdExist(int id) {
        return postRepository.existsById(id);
    }
}
