package com.ntnghia.nghianguyenblog.controller;

import com.ntnghia.nghianguyenblog.entity.Post;
import com.ntnghia.nghianguyenblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blog/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return postService.findById(id);
    }

    @GetMapping(value = "/search", params="keyword")
    public List<Post> getByKeyword(@RequestParam("keyword") String keyword) {
        return postService.findByKeyword(keyword);
    }

    @PostMapping("/{categoryId}/{userId}")
    public Post post(@PathVariable(value = "categoryId") int categoryId,
                     @PathVariable(value = "userId") int userId,
                     @Valid @RequestBody Post post){
        return postService.savePost(post, userId, categoryId);
    }

    @PutMapping("/{id}")
    public Post put(@PathVariable int id, @Valid @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        postService.deletePost(id);
    }
}
