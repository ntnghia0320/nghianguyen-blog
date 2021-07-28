package com.ntnghia.blog.controller;

import com.ntnghia.blog.entity.Post;
import com.ntnghia.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/active-post")
    public List<Post> getActivePost() {
        return postService.getActivePost();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return postService.findById(id);
    }

    @GetMapping("/category/{id}")
    public List<Post> getByCategoryId(@PathVariable int id) {
        return postService.findByCategoryId(id);
    }

    @GetMapping("/user/{id}")
    public List<Post> getByUserId(@PathVariable int id) {
        return postService.findByUserId(id);
    }

    @GetMapping(value = "/search", params = "keyword")
    public List<Post> getByKeyword(@RequestParam("keyword") String keyword) {
        return postService.findByKeyword(keyword);
    }

    @PostMapping("/{categoryId}/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Post post(@PathVariable(value = "categoryId") int categoryId,
                     @PathVariable(value = "userId") int userId,
                     @Valid @RequestBody Post post) {
        return postService.savePost(post, categoryId, userId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Post put(@PathVariable int id, @Valid @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void delete(@PathVariable int id) {
        postService.deletePost(id);
    }
}
